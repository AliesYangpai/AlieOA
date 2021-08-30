package org.alieoa.work.api

import android.service.autofill.UserData
import retrofit2.http.GET

interface UserService {

    @GET("alieoa/user/userinfo")
    suspend fun getUserInfo()
}