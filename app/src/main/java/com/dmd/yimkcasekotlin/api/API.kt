package com.dmd.yimkcasekotlin.api

import com.dmd.yimkcasekotlin.models.ServiceResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("haberler")
    fun getBaseData(@Query("category") category: Any,
                    @Query("count") count: Any,
                    @Query("offset") offset: Any,
                    @Query("deviceType") deviceType: Any,
                    @Query("userId") userId: Any): Single<ServiceResponse>
}