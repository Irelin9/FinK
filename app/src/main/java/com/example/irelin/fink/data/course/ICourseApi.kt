package com.example.irelin.fink.data.course

import com.example.irelin.fink.data.models.CourseResponse
import io.reactivex.Single
import retrofit2.http.GET


interface ICourseApi {
    @GET("daily_json.js")
    fun getCourse() : Single<CourseResponse>
}