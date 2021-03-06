package com.example.irelin.fink.dagger

import com.example.irelin.fink.data.course.CourseRepository
import com.example.irelin.fink.data.transaction.TransactionsRepository
import com.example.irelin.fink.data.course.ICourseRepository
import com.example.irelin.fink.data.transaction.ITransactionsRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    fun provideCourseRepository(retrofit: Retrofit) : ICourseRepository = CourseRepository(retrofit)

    @Provides
    fun provideTransactionsRepository() : ITransactionsRepository = TransactionsRepository()

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://www.cbr-xml-daily.ru/")
            .build()
}