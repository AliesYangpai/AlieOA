package org.alieoa.work.api

import retrofit2.http.GET

interface UserService {

    @GET("alieoa/user/userinfo")
    suspend fun getUserInfo()
}