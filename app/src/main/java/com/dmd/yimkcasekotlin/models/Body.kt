package com.dmd.yimkcasekotlin.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Body (
	@SerializedName("p") val p : String
) : Serializable