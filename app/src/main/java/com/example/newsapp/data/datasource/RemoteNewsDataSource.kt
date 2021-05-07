package com.example.newsapp.data.datasource

import com.example.newsapp.data.api.NewsService
import com.example.newsapp.data.model.News
import io.reactivex.Single

/**
 * Created by ivankiv on 05,May,2021
 */
class RemoteNewsDataSource(private val newsService: NewsService) {

    fun fetchNews(lang: String): Single<List<News>> {
        return newsService
            .fetchNews(lang)
            .map { return@map it.news }
            .firstOrError();
    }
}