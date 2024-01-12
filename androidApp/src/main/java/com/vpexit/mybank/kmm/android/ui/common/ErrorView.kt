package com.vpexit.mybank.kmm.android.ui.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vpexit.mybank.kmm.android.R
import com.vpexit.mybank.kmm.android.theme.Blue
import com.vpexit.mybank.kmm.android.theme.LabelSmall

@Composable
fun ErrorView(cause: String, visible: Boolean, onRefreshClicked: () -> Unit) {
    AnimatedVisibility(visible = visible, enter = fadeIn(), exit = fadeOut()) {
        Box(Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 10.dp),
            ) {
                Text(
                    text = cause,
                    color = Blue,
                    style = LabelSmall,
                    textAlign = TextAlign.Center
                )
                IconButton(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(50.dp)
                        .align(Alignment.CenterHorizontally),
                    onClick = onRefreshClicked
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        tint = Blue,
                        contentDescription = stringResource(R.string.show_less_content_description)
                    )
                }
            }
        }
    }
}