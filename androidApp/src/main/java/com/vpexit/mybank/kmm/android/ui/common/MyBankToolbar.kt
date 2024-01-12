package com.vpexit.mybank.kmm.android.ui.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vpexit.mybank.kmm.android.theme.Background
import com.vpexit.mybank.kmm.android.theme.Black
import com.vpexit.mybank.kmm.android.theme.LabelSmall
import com.vpexit.mybank.kmm.android.theme.TitleLarge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBankToolbar(
    @StringRes titleResId: Int,
    withBackButton: Boolean = false,
    onBackPressed: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = {
            Text(
                modifier = Modifier.padding(top = if (withBackButton) 0.dp else 30.dp),
                text = stringResource(titleResId),
                color = Black,
                style = if (withBackButton)
                    LabelSmall
                else
                    TitleLarge
            )
        },
        navigationIcon = {
            if (withBackButton)
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIos,
                        contentDescription = "back"
                    )
                }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Background,
            titleContentColor = Black
        )
    )
}