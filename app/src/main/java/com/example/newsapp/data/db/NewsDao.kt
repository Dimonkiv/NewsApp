package com.example.newsapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.newsapp.data.model.News
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by ivankiv on 06,July,2021
 */
@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getAll(): Single<List<News>>

    @Query("SELECT * FROM news WHERE id =:id")
    fun getNewsById(id: Long): Single<News>

    @Insert
    fun insert(news: News): Completable

    @Delete
    fun deleteAll(news: List<News>)
}