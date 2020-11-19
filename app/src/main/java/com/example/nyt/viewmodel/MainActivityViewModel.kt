package com.example.nyt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nyt.App
import com.example.nyt.data.MostPopular
import com.example.nyt.servicemanager.NetworkService
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

open class MainActivityViewModel : ViewModel() {

    @Inject
    lateinit var service: NetworkService

    val response: PublishSubject<MostPopular> = PublishSubject.create()

    fun getMostPopular() {

        service.getPopularItems("KHUsF7A2BHhKkZMlmukqvwKdPqsGUdZ5")
        service.subject.subscribe {
            response.onNext(it)
        }
    }

    init {
        App().component.inject(this)
    }
}