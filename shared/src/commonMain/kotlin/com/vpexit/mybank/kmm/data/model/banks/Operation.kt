package com.vpexit.mybank.kmm.data.model.banks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Operation(
    @SerialName("id")
    var id: String? = null,
    @SerialName("title")
    var title: String? = null,
    @SerialName("amount")
    var amount: String? = null,
    @SerialName("category")
    var category: String? = null,
    @SerialName("date")
    var date: String? = null
)