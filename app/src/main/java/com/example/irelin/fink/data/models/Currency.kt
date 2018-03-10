package com.example.irelin.fink.data.models

import com.google.gson.annotations.SerializedName


class Currency(@SerializedName("ID") val id: String,
               @SerializedName("CharCode") val charCode: String,
               @SerializedName("Nominal") val nominal: Int,
               @SerializedName("Value") val value: Double,
               @SerializedName("Previous") val previous: Double) {
}