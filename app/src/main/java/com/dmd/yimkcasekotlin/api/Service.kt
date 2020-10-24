package com.dmd.yimkcasekotlin.api

import com.dmd.yimkcasekotlin.models.ServiceResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    private val BASE_URL = "http://app.haberler.com/services/haberlercom/2.11/service.asmx/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(API::class.java)

    fun getData() : Single<ServiceResponse> {
        return api.getBaseData(category = "manset",
            count = 35,
            offset = 0,
            deviceType = 1,
            userId = "61ed99e0c09a8664")
    }
}