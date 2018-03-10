package com.example.irelin.fink.data.course

import com.example.irelin.fink.data.models.Currency
import io.reactivex.Single
import retrofit2.Retrofit


class CourseRepository(retrofit: Retrofit) : ICourseRepository {
    private var courseApi: CourseApi = CourseApi(retrofit)

    override fun getCourse() : Single<Map<String, Currency>> {
        return courseApi.getCourse()
                .flatMap({it -> Single.just(it.currency)})
    }
}