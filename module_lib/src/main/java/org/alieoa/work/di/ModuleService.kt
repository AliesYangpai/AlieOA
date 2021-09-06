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

    /**
     * 用户服务相关接口
     * @param retrofit Retrofit
     * @return UserService
     */
    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit):UserService = retrofit.create(UserService::class.java)

    /**
     * 工作模块相关接口
     * @param retrofit Retrofit
     * @return WorkSectionService
     */
    @Provides
    @Singleton
    fun provideWorkSectionService(retrofit: Retrofit):WorkSectionService = retrofit.create(WorkSectionService::class.java)
}
