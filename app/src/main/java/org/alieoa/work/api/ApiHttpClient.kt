package org.alieoa.work.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHttpClient {

    private var mRetrofit: Retrofit? = null

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(ConstUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    companion object {
        @Volatile
        private var mInstance: ApiHttpClient? = null
        fun getInstance(): ApiHttpClient {
            return mInstance ?: synchronized(this) {
                mInstance ?: ApiHttpClient().also {
                    mInstance = it
                }
            }
        }
    }

    fun <T> generateService(clazz: Class<T>) = mRetrofit?.create(clazz)
}