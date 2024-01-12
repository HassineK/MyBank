package com.vpexit.mybank.kmm.android.ui.navigation

import com.google.gson.Gson
import com.vpexit.mybank.kmm.data.model.banks.Account

class AccountArgType : JsonNavType<Account>() {

    override fun fromJsonParse(value: String): Account = Gson().fromJson(value, Account::class.java)

    override fun Account.getJsonParse(): String = Gson().toJson(this)
}