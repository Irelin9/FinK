package com.example.irelin.fink.data.course

import com.example.irelin.fink.data.models.Currency
import io.reactivex.Single


interface ICourseRepository {
    fun getCourse() : Single<Map<String, Currency>>
}