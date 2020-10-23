package com.dmd.yimkcasekotlin.models

import com.google.gson.annotations.SerializedName

data class News (

	@SerializedName("category") val category : String,
	@SerializedName("title") val title : String,
	@SerializedName("spot") val spot : String,
	@SerializedName("redirects") val redirects : Boolean,
	@SerializedName("isAdvertorial") val isAdvertorial : Boolean,
	@SerializedName("publishDate") val publishDate : String,
	@SerializedName("id") val id : Double,
	@SerializedName("imageUrl") val imageUrl : String,
	@SerializedName("videoUrl") val videoUrl : String,
	@SerializedName("webUrl") val webUrl : String,
	@SerializedName("commentCount") val commentCount : Double,
	@SerializedName("imageSize") val imageSize : String,
	@SerializedName("body") val body : List<Body>,
	@SerializedName("related") val related : List<Any>,
	@SerializedName("emoji") val emoji : Emoji
)