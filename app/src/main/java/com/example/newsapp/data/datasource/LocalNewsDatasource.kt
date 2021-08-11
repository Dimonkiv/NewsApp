package com.example.newsapp.data.datasource

import com.example.newsapp.data.db.NewsDao
import com.example.newsapp.data.model.BaseResponse
import com.example.newsapp.data.model.News
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by ivankiv on 10,July,2021
 */
class LocalNewsDatasource(private val newsDao: NewsDao) {

    fun fetchNews(): Single<List<News>> {
        return newsDao
            .getAll()
    }

    fun fetchNewsById(id: Long): Single<News> {
        return newsDao.getNewsById(id)
    }

    fun writeNews(remoteItems: List<News>): Single<List<News>> {
        return Observable.just(remoteItems)
            .flatMapIterable { items -> items }
            .flatMap { item ->
                return@flatMap newsDao.insert(item)
                    .andThen(Observable.just(item))
            }
            .toList()
    }

    fun removeAllNews(items: List<News>): Single<BaseResponse> {
        return Completable.fromCallable {
            newsDao.deleteAll(items)
        }.andThen(Single.just(BaseResponse.OK))
    }
}