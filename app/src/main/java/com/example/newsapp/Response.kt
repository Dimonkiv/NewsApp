package com.example.newsapp

import java.lang.Exception

/**
 * Created by ivankiv on 11,August,2021
 */
sealed class Response<out T> {

    data class Success<T>(val data: T): Response<T>()

    data class Error<T>(val data: T, val exception: Exception): Response<T>()
}
