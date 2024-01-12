package com.vpexit.mybank.kmm.android.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vpexit.mybank.kmm.android.theme.Background
import com.vpexit.mybank.kmm.android.theme.MyBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBankTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Background
                ) {
                    MainView()
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun MainActivityPreview() {
    MyBankTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Background
        ) {
            MainView()
        }
    }
}