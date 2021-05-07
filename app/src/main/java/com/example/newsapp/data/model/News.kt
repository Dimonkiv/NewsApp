package com.example.newsapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ivankiv on 29,April,2021
 */
data class News(
    @SerializedName("url") val url: String,
    @SerializedName("source") val source: String,
    @SerializedName("title") val title: String,
    @SerializedName("pubDate") val date: String,
    @SerializedName("country") val country: String,
    @SerializedName("language") val lang: String,
    @SerializedName("description") val description: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("content") val content: String
)