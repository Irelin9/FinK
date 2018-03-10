package com.example.irelin.fink.custom

import android.app.Application
import com.example.irelin.fink.dagger.AppComponent
import com.example.irelin.fink.dagger.DaggerAppComponent
import com.example.irelin.fink.dagger.DataModule
import io.realm.Realm


class Application : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = buildComponent()
        Realm.init(this)
    }

    protected fun buildComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .dataModule(DataModule())
                .build()
    }
}