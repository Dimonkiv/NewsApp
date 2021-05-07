package com.example.newsapp.data.api

import com.example.newsapp.data.model.NewsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ivankiv on 29,April,2021
 */
interface NewsService {
    @GET("/v1/news")
    fun fetchNews(@Query("language") lang: String): Flowable<NewsResponse>
}