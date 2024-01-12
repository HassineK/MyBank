package com.vpexit.mybank.kmm.data.model.banks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bank(
    @SerialName("name")
    var name: String? = null,
    @SerialName("isCA")
    var isCA: Int? = null,
    @SerialName("accounts")
    var accounts: List<Account>
)