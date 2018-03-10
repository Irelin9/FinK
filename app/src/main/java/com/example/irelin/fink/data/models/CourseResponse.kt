package com.example.irelin.fink.data.models

import com.google.gson.annotations.SerializedName


data class CourseResponse(@SerializedName("Date") val date: String, @SerializedName("Valute") val currency: Map<String, Currency>) {
}