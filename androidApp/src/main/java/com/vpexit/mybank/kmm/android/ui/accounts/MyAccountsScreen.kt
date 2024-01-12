package com.vpexit.mybank.kmm.android.ui.accounts

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.vpexit.mybank.kmm.android.R
import com.vpexit.mybank.kmm.android.theme.Background
import com.vpexit.mybank.kmm.android.theme.Black
import com.vpexit.mybank.kmm.android.theme.LabelSmall
import com.vpexit.mybank.kmm.android.theme.MyBankTheme
import com.vpexit.mybank.kmm.android.ui.common.ErrorView
import com.vpexit.mybank.kmm.android.ui.common.LoadingView
import com.vpexit.mybank.kmm.android.ui.common.MyBankToolbar
import com.vpexit.mybank.kmm.android.ui.navigation.Screens
import com.vpexit.mybank.kmm.android.utils.Utils.getCategoryName
import com.vpexit.mybank.kmm.android.utils.cast
import com.vpexit.mybank.kmm.android.utils.getDemoSdk
import com.vpexit.mybank.kmm.data.model.banks.Account
import com.vpexit.mybank.kmm.data.model.banks.Bank
import com.vpexit.mybank.kmm.presentation.banks.BaseViewState
import com.vpexit.mybank.kmm.presentation.banks.BanksUiState

@Composable
fun MyAccountsScreen(
    navController: NavController? = null
) {
    val context = LocalContext.current
    val sdk = context.getDemoSdk()
    val viewModel = viewModel { sdk.banksViewModel }
    val uiState by viewModel.uiState.collectAsState()
    var showLoader = false
    var showError = false
    var cause = stringResource(R.string.common_system_error)
    var banks: Map<Int?, List<Bank>> = mapOf()
    when (uiState) {
        is BaseViewState.Success -> {
            uiState.cast<BaseViewState.Success<BanksUiState>>().value.banks.let {
                if (it.isNotEmpty()) {
                    showLoader = false
                    banks = it
                }
            }
        }

        is BaseViewState.IsLoading -> {
            showLoader = uiState.cast<BaseViewState.IsLoading<Boolean>>().value
        }

        is BaseViewState.Error -> {
            showLoader = false
            showError = true
            uiState.cast<BaseViewState.Error>().throwable.message?.let {
                cause = it
            }
        }

        else -> {}
    }

    MyAccountsBody { padding ->
        MyAccountsContent(
            padding = padding,
            banksList = banks
        ) { account ->
            navController?.navigate(Screens.AccountDetails.addValue(account = account))
        }
    }

    ErrorView(
        cause = cause,
        visible = showError,
        onRefreshClicked = viewModel::collectBanks
    )

    LoadingView(showLoader)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyAccountsBody(
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        containerColor = Background,
        topBar = {
            MyBankToolbar(
                R.string.my_accounts,
            )
        },
        content = {
            pageContent.invoke(it)
        }
    )
}

@Composable
private fun MyAccountsContent(
    padding: PaddingValues,
    banksList: Map<Int?, List<Bank>>,
    onAccountSelected: (Account) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .padding(padding)
    ) {
        banksList.forEach { (category, banks) ->
            item {
                Text(
                    modifier = Modifier.padding(15.dp),
                    text = stringResource(id = getCategoryName(category)),
                    color = Black,
                    style = LabelSmall
                )
            }
            items(banks.sortedBy { bank -> bank.name }) { bank ->
                BankItemRow(
                    item = bank,
                    onAccountSelected = { onAccountSelected(it) }
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun MyAccountsScreenPreview() {
    MyBankTheme {
        Surface {
            MyAccountsScreen()
        }
    }
}