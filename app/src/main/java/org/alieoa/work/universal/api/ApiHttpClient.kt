package org.alieoa.work.universal.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiHttpClient {

    private var mRetrofit: Retrofit? = null

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(ConstUrl.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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