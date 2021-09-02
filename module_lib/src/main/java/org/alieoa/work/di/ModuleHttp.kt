package org.alieoa.work.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.alieoa.work.ConstUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleHttp {
    @Provides
    @Singleton
    fun provideHttpClient(): Retrofit = Retrofit.Builder()
        .baseUrl(ConstUrl.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}