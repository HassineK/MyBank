package com.vpexit.mybank.kmm.android.ui.accounts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.vpexit.mybank.kmm.android.R
import com.vpexit.mybank.kmm.android.theme.Black
import com.vpexit.mybank.kmm.android.theme.Dark_gray
import com.vpexit.mybank.kmm.android.theme.Gray
import com.vpexit.mybank.kmm.android.theme.LabelSmall
import com.vpexit.mybank.kmm.data.model.banks.Account

@Composable
fun AccountItemRow(
    item: Account,
    onAccountSelected: (Account) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 50.dp)
    ) {
        val (name, balance, expand, divider) = createRefs()

        Text(
            modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            },
            text = item.holder ?: "-",
            color = Black,
            style = LabelSmall
        )

        Text(
            modifier = Modifier.constrainAs(balance) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(expand.start)
            },
            text = "${item.balance} €",
            color = Dark_gray,
            style = LabelSmall
        )

        IconButton(
            modifier = Modifier
                .padding(end = 15.dp)
                .constrainAs(expand) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            onClick = {
                onAccountSelected(item)
            })
        {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                tint = Dark_gray,
                contentDescription = stringResource(R.string.show_forward_content_description)
            )
        }

        Divider(
            modifier = Modifier.constrainAs(divider) {
                top.linkTo(name.bottom, 15.dp)
            },
            thickness = 1.dp,
            color = Gray
        )
    }
}