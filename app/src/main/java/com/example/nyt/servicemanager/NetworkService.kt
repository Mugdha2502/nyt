package com.example.nyt.servicemanager

import com.example.nyt.data.MostPopular
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class NetworkService {

    val subject: PublishSubject<MostPopular> = PublishSubject.create()

    val mostPopularApi: MostPopularApi by lazy {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient().newBuilder().addInterceptor(interceptor).build())
            .build()

        retrofit.create(MostPopularApi::class.java)
    }

    fun getPopularItems(apiKey: String) {
        mostPopularApi.getPopularItems(apiKey).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe({
                if (it.isSuccessful)
                    subject.onNext(it.body()!!)
            }, {
                it.printStackTrace()
            })
    }


}