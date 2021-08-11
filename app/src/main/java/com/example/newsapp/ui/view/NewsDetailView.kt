package com.example.newsapp.ui.view

import com.example.newsapp.data.model.News

/**
 * Created by ivankiv on 11,August,2021
 */
interface NewsDetailView {

    fun displayNews(item: News)
}