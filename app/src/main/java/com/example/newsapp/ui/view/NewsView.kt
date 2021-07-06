package com.example.newsapp.ui.view

import com.example.newsapp.data.model.News

/**
 * Created by ivankiv on 03,July,2021
 */
interface NewsView {
    fun displayNews(items: List<News>)
}