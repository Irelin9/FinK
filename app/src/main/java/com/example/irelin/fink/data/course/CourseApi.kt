package com.example.irelin.fink.data.course

import com.example.irelin.fink.data.models.CourseResponse
import io.reactivex.Single
import retrofit2.Retrofit


class CourseApi(retrofit: Retrofit) {
    private var courseApi: ICourseApi = retrofit.create(ICourseApi::class.java)

    fun getCourse(): Single<CourseResponse> = courseApi.getCourse()
}