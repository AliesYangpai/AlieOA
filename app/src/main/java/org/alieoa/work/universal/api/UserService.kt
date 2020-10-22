package org.alieoa.work.universal.api

import io.reactivex.Observable
import org.alieoa.work.entity.FrequentContact
import org.alieoa.work.universal.db.entity.User
import retrofit2.http.GET

interface UserService {

    @GET("alieoa/user")
    fun getUserInfo(): Observable<User>

    @GET("alieoa/user/frequentcontact")
    fun getUserFrequentContacts():Observable<ArrayList<FrequentContact>>
}