package org.alieoa.work

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHttpClient @Inject constructor() {

    val mRetrofit = Retrofit.Builder()
        .baseUrl(ConstUrl.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}