package com.example.nyt.data

import com.google.gson.annotations.SerializedName

data class MostPopular(

	@field:SerializedName("results")
	val data: List<Data>,

	@field:SerializedName("status")
	val status: String? = null
)

data class Data(

	@field:SerializedName("des_facet")
	val facets: List<String>,

	@field:SerializedName("uri")
	val uri: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("section")
	val section: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("published_date")
	val date: String? = null
)
