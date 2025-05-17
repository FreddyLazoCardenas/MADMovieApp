package com.freddy.movieapi.data.remote

import com.freddy.movieapi.data.BuildConfig // Changed from com.freddy.movieapi.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .header("Authorization", BuildConfig.API_KEY)
            .build()
        return chain.proceed(newRequest)
    }
}
