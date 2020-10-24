package com.dmd.yimkcasekotlin.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ServiceResponse (
    @SerializedName("news") val news : ArrayList<News>
)