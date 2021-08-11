package com.example.newsapp.data.datasource

import com.example.newsapp.data.api.NewsService
import com.example.newsapp.data.model.News
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by ivankiv on 05,May,2021
 */
class RemoteNewsDataSource(private val newsService: NewsService) {

    fun fetchNews(apiKey: String, lang: String): Observable<List<News>> {
        return newsService
            .fetchNews(apiKey, lang)
            .map {
                return@map it.news
            }
    }
}