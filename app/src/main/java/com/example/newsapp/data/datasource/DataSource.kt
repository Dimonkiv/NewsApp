package com.example.newsapp.data.datasource

import io.reactivex.Completable
import io.reactivex.Observable


/**
 * Created by ivankiv on 12,July,2021
 */
interface DataSource<T : Any> : SimpleDataSource<T> {

    fun getById(id: Long): Observable<T>

    fun saveAll(items: List<T>): Observable<List<T>>

    fun removeAll(): Completable
}