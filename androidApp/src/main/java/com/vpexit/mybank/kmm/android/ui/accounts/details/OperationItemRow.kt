package com.vpexit.mybank.kmm.android.ui.accounts.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.vpexit.mybank.kmm.android.theme.Black
import com.vpexit.mybank.kmm.android.theme.Dark_gray
import com.vpexit.mybank.kmm.android.theme.Gray
import com.vpexit.mybank.kmm.android.theme.LabelSmall
import com.vpexit.mybank.kmm.android.theme.White
import com.vpexit.mybank.kmm.android.utils.Utils.convertDate
import com.vpexit.mybank.kmm.data.model.banks.Operation

@Composable
fun OperationItemRow(
    item: Operation
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(White)
    ) {
        val (title, amount, date, divider) = createRefs()

        Text(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, 15.dp)
                start.linkTo(parent.start, 25.dp)
            },
            text = item.title ?: "-",
            color = Black,
            style = LabelSmall
        )

        Text(
            modifier = Modifier.constrainAs(amount) {
                top.linkTo(title.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end, 25.dp)
            },
            text = "${item.amount} €",
            color = Dark_gray,
            style = LabelSmall
        )

        Text(
            modifier = Modifier.constrainAs(date) {
                top.linkTo(title.bottom)
                start.linkTo(title.start, 10.dp)
            },
            text = convertDate(item.date),
            color = Dark_gray,
            style = LabelSmall
        )

        Divider(
            modifier = Modifier.constrainAs(divider) {
                start.linkTo(parent.start, 15.dp)
                top.linkTo(date.bottom, 15.dp)
            },
            thickness = 1.dp,
            color = Gray
        )
    }
}