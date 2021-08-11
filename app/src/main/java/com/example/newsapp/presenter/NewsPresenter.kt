package com.example.newsapp.presenter

import android.util.Log
import com.example.newsapp.Constant
import com.example.newsapp.data.NewsRepository
import com.example.newsapp.data.api.RetrofitBuilder
import com.example.newsapp.data.datasource.RemoteNewsDataSource
import com.example.newsapp.ui.view.NewsView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by ivankiv on 03,July,2021
 */
class NewsPresenter(private val newsRepository: NewsRepository) {
    private lateinit var view: NewsView


    fun attachView(view: NewsView) {
        this.view = view
    }

    fun fetchNews() {
        val disposable = newsRepository
            .fetchNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {res -> view.displayNews(res)},
                {err -> Log.d("TAG", "err - $err")}
            )
    }
}