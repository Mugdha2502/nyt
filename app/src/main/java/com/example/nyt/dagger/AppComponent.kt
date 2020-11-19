package com.example.nyt.dagger

import com.example.nyt.App
import com.example.nyt.ui.main.MainActivity
import com.example.nyt.data.AppDatabase
import com.example.nyt.servicemanager.NetworkService
import com.example.nyt.viewmodel.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(app: App)

    fun inject(activity: MainActivity)

    fun inject(viewModel: MainActivityViewModel)

    fun addressService(): NetworkService

    fun provideAppDatabase(): AppDatabase
}