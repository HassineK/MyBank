package com.vpexit.mybank.kmm.android.ui.accounts.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vpexit.mybank.kmm.android.R
import com.vpexit.mybank.kmm.android.theme.Background
import com.vpexit.mybank.kmm.android.theme.Black
import com.vpexit.mybank.kmm.android.theme.MyBankTheme
import com.vpexit.mybank.kmm.android.ui.common.MyBankToolbar
import com.vpexit.mybank.kmm.android.ui.preview.PreviewData.account
import com.vpexit.mybank.kmm.data.model.banks.Account
import com.vpexit.mybank.kmm.data.model.banks.Operation

@Composable
fun AccountDetailsScreen(
    navController: NavController? = null,
    account: Account?
) {
    AccountDetailsBody(navController) { padding ->
        AccountDetailsContent(
            padding = padding,
            account = account
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AccountDetailsBody(
    navController: NavController?,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        containerColor = Background,
        topBar = {
            MyBankToolbar(
                titleResId = R.string.my_accounts,
                withBackButton = true,
                onBackPressed = { navController?.navigateUp() }
            )
        },
        content = {
            pageContent.invoke(it)
        }
    )
}

@Composable
private fun AccountDetailsContent(
    padding: PaddingValues,
    account: Account?
) {
    account?.let {
        LazyColumn(
            modifier = Modifier
                .padding(padding)
        ) {
            item {
                Column {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "${account.balance} €",
                        color = Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        textAlign = TextAlign.Center,
                        text = account.holder ?: "-",
                        color = Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
            val sortedList = account.operations.sortedWith(
                compareByDescending<Operation> { it.date }
                    .thenBy { it.title }
            )
            items(sortedList) { operation ->
                OperationItemRow(item = operation)
            }
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun AccountDetailsScreenPreview() {
    MyBankTheme {
        Surface {
            AccountDetailsScreen(account = account)
        }
    }
}