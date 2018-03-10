package com.example.irelin.fink.dagger

import com.example.irelin.fink.main.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(DataModule::class))
@Singleton
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)
}