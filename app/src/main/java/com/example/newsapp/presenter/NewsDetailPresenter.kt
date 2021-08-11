package com.example.newsapp.presenter

import android.util.Log
import com.example.newsapp.data.NewsRepository
import com.example.newsapp.ui.view.NewsDetailView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ivankiv on 11,August,2021
 */
class NewsDetailPresenter(private val newsRepository: NewsRepository) {

    private lateinit var view: NewsDetailView
    private var id: Long = 0

    fun updateId(id: Long) {
        this.id = id
    }

    fun attachView(view: NewsDetailView) {
        this.view = view
    }

    fun fetchNews() {
        val disposable = newsRepository
            .fetchNewsById(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {item -> view.displayNews(item)},
                {err -> Log.d("TAG", "err - $err")}
            )
    }


}