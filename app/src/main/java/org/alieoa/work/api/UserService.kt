package org.alieoa.work.api

import org.alieoa.work.db.entity.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("alieoa/user")
    fun getUserInfo(): Call<User>
}