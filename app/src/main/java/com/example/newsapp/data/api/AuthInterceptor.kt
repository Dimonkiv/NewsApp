package com.example.newsapp.data.api

import com.example.newsapp.Constant
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by ivankiv on 30,April,2021
 */
class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestWithUserAgent = originalRequest.newBuilder()
            .addHeader("x-api-key", Constant.API_KEY)
            .build()

        return chain.proceed(requestWithUserAgent)
    }
}