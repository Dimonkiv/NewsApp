package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.newsapp.data.api.RetrofitBuilder
import com.example.newsapp.data.datasource.RemoteNewsDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val disposable = RemoteNewsDataSource(RetrofitBuilder.newsService)
            .fetchNews(Constant.API_KEY,"uk")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { res -> Log.d("TAG", "Receive ${res.size} news") },
                { err -> Log.d("TAG", "Error - ${err.message}") }
            )
    }
}