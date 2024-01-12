package com.vpexit.mybank.kmm.android.ui.others

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vpexit.mybank.kmm.android.R
import com.vpexit.mybank.kmm.android.theme.Background
import com.vpexit.mybank.kmm.android.theme.MyBankTheme
import com.vpexit.mybank.kmm.android.ui.common.MyBankToolbar

@Composable
fun OthersScreen(
) {
    OthersBody {
        OthersContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OthersBody(
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            MyBankToolbar(
                R.string.others,
            )
        }, content = {
            pageContent.invoke(it)
        }
    )
}

@Composable
private fun OthersContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(id = R.string.others)
        )
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun OthersScreenPreview() {
    MyBankTheme {
        Surface {
            OthersScreen()
        }
    }
}