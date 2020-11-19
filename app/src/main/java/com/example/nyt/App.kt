package com.example.nyt

import android.app.Application
import com.example.nyt.dagger.AppComponent
import com.example.nyt.dagger.AppModule
import com.example.nyt.dagger.DaggerAppComponent

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}