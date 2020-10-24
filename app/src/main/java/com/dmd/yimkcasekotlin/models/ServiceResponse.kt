package com.dmd.yimkcasekotlin.models

import com.google.gson.annotations.SerializedName

data class ServiceResponse (
    @SerializedName("news") val news : ArrayList<News>
)