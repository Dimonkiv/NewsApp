package com.example.newsapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ivankiv on 29,April,2021
 */
data class NewsResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("numResults") val numResults: Int,
    @SerializedName("hits") val news: List<News>
) {
}