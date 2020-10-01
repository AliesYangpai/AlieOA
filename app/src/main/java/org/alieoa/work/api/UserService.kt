package org.alieoa.work.api

import io.reactivex.Observable
import org.alieoa.work.db.entity.User
import retrofit2.http.GET

interface UserService {

    @GET("alieoa/user")
    fun getUserInfo(): Observable<User>
}