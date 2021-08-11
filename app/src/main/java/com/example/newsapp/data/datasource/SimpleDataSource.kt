package com.example.newsapp.data.datasource

import io.reactivex.Observable

/**
 * Created by ivankiv on 12,July,2021
 */
interface SimpleDataSource<T : Any> {

    fun getAll(): Observable<List<T>>
}