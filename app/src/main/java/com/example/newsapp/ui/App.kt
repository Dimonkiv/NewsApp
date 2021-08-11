package com.example.newsapp.ui

import android.app.Application
import com.example.newsapp.data.NewsRepository
import com.example.newsapp.data.api.RetrofitBuilder
import com.example.newsapp.data.datasource.LocalNewsDatasource
import com.example.newsapp.data.datasource.RemoteNewsDataSource
import com.example.newsapp.data.db.AppDatabase

/**
 * Created by ivankiv on 10,July,2021
 */
class App : Application() {

    private lateinit var newsRepository: NewsRepository

    override fun onCreate() {
        super.onCreate()
        initNewsRepository()
    }

    private fun initNewsRepository() {
        val remoteDataSource = RemoteNewsDataSource(RetrofitBuilder.newsService)
        val localDataSource = LocalNewsDatasource(AppDatabase.getDatabase(this).newsDao())

        newsRepository = NewsRepository(localDataSource, remoteDataSource)
    }

    fun provideNewsRepository(): NewsRepository {
        return newsRepository
    }
}