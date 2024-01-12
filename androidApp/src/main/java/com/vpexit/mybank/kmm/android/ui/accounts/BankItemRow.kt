package com.vpexit.mybank.kmm.android.ui.accounts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.vpexit.mybank.kmm.android.R
import com.vpexit.mybank.kmm.android.theme.Blue
import com.vpexit.mybank.kmm.android.theme.Dark_gray
import com.vpexit.mybank.kmm.android.theme.Gray
import com.vpexit.mybank.kmm.android.theme.LabelSmall
import com.vpexit.mybank.kmm.android.theme.White
import com.vpexit.mybank.kmm.data.model.banks.Account
import com.vpexit.mybank.kmm.data.model.banks.Bank

@Composable
fun BankItemRow(
    item: Bank,
    onAccountSelected: (Account) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(White)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            val (name, balance, expand) = createRefs()

            Text(
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
                text = item.name ?: "-",
                color = Blue,
                style = LabelSmall
            )

            val totalBalance = item.accounts.sumOf { account -> account.balance ?: 0.0 }
            Text(
                modifier = Modifier.constrainAs(balance) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(expand.start)
                },
                text = "${String.format("%.2f", totalBalance).toDouble()} €",
                color = Dark_gray,
                style = LabelSmall
            )

            IconButton(
                modifier = Modifier.constrainAs(expand) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                onClick = {
                    isExpanded = isExpanded.not()
                })
            {
                Icon(
                    imageVector = if (isExpanded)
                        Icons.Filled.ExpandLess
                    else
                        Icons.Filled.ExpandMore,
                    tint = Dark_gray,
                    contentDescription = if (isExpanded)
                        stringResource(R.string.show_more_content_description)
                    else
                        stringResource(R.string.show_less_content_description)
                )
            }
        }
        if (isExpanded) {
            Divider(
                modifier = Modifier.padding(start = 15.dp),
                thickness = 1.dp,
                color = Gray
            )
            val sortedList = item.accounts.sortedBy { it.holder }
            repeat(sortedList.size) { index ->
                AccountItemRow(
                    item = sortedList[index],
                    onAccountSelected = { onAccountSelected(it) })
            }
        }
    }
}