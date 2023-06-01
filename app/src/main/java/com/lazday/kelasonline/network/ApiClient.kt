package com.lazday.kelasonline.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//private const val baseUrl = "https://kedaibelaj
private const val baseUrl = "https://demo.lazday.com/kelas-online/"
private const val baseAPI = "https://demo.lazday.com/kelas-online/"
//private const val baseUrl = "https://kedaibelajar.com/"

object ApiClient {

    fun getService(): ApiService {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val gson = GsonBuilder().serializeNulls()
                .create()

        return Retrofit.Builder()
            .baseUrl( baseUrl )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(ApiService::class.java)

    }
}