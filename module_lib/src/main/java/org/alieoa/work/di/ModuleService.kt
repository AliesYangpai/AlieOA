package org.alieoa.work.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.alieoa.work.ApiHttpClient
import org.alieoa.work.api.*
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleService {

    @Provides
    @Singleton
    fun provideUserService(apiHttpClient: ApiHttpClient)= apiHttpClient.mRetrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideReportService(apiHttpClient: ApiHttpClient) = apiHttpClient.mRetrofit.create(ReportService::class.java)

    @Provides
    @Singleton
    fun provideClientService(apiHttpClient: ApiHttpClient) = apiHttpClient.mRetrofit.create(ClientService::class.java)

    @Provides
    @Singleton
    fun provideApproveService(apiHttpClient: ApiHttpClient) = apiHttpClient.mRetrofit.create(ApproveService::class.java)

    @Provides
    @Singleton
    fun provideAnnounceService(apiHttpClient: ApiHttpClient) = apiHttpClient.mRetrofit.create(AnnounceService::class.java)

    @Provides
    @Singleton
    fun provideAllService(retrofit: Retrofit):AllChildService = retrofit.create(AllChildService::class.java)
}
