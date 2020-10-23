package com.dmd.yimkcasekotlin.Services

import com.dmd.yimkcasekotlin.models.News
import com.dmd.yimkcasekotlin.models.ServiceResponse
import io.reactivex.Single
import retrofit2.http.GET

interface API {
    @GET("haberler?category=manset&count=35&offset=0&deviceType=1&userId=61ed99e0c09a8664")
    fun getBaseData(): Single<ServiceResponse>
}