package com.vpexit.mybank.kmm.android.utils

import android.annotation.SuppressLint
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.vpexit.mybank.kmm.android.R
import java.sql.Date
import java.text.SimpleDateFormat

object Utils {
    object NoRippleTheme : RippleTheme {
        @Composable
        override fun defaultColor() = Color.Unspecified

        @Composable
        override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
    }

    fun getCategoryName(isCA: Int?): Int {
        return if (isCA == 1)
            R.string.agricultural_credit_title
        else
            R.string.other_banks_title
    }

    @SuppressLint("SimpleDateFormat")
    fun convertDate(s: String?): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        if (s.isNullOrEmpty())
            return "-/-/-"
        return try {
            val netDate = Date((s.toLong() * 1000))
            sdf.format(netDate)
        } catch (e: Exception) {
            "-/-/-"
        }
    }
}