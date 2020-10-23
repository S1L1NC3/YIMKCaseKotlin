package com.dmd.yimkcasekotlin.models

import com.google.gson.annotations.SerializedName

data class Emoji (

	@SerializedName("loved") val loved : Double,
	@SerializedName("clappingHand") val clappingHand : Double,
	@SerializedName("thumbsDown") val thumbsDown : Double,
	@SerializedName("smiling") val smiling : Double,
	@SerializedName("crying") val crying : Double,
	@SerializedName("angry") val angry : Double,
	@SerializedName("suprised") val suprised : Double
)