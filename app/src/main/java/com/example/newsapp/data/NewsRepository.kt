package com.example.newsapp.data

import com.example.newsapp.Constant
import com.example.newsapp.data.datasource.LocalNewsDatasource
import com.example.newsapp.data.datasource.RemoteNewsDataSource
import com.example.newsapp.data.model.BaseResponse
import com.example.newsapp.data.model.News
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by ivankiv on 10,July,2021
 */
class NewsRepository(
    private val localDataSource: LocalNewsDatasource,
    private val remoteDataSource: RemoteNewsDataSource
) {

    fun fetchNews(): Single<List<News>> {
        return remoteDataSource
            .fetchNews(Constant.API_KEY, "en")
            .firstOrError()
            .flatMap { items ->
                return@flatMap localDataSource.writeNews(items)
            }
            .flatMap {
                return@flatMap localDataSource.fetchNews()
            }
    }

    fun fetchNewsById(id: Long): Single<News> {
        return localDataSource
            .fetchNewsById(id)
    }

    fun removeAllNews(): Single<BaseResponse> {
        return localDataSource
            .fetchNews()
            .flatMap { items ->
                return@flatMap localDataSource.removeAllNews(items)
            }
    }


}