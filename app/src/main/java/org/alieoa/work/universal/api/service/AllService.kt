package org.alieoa.work.universal.api.service

import io.reactivex.Observable
import org.alieoa.work.entity.AllChildBean
import retrofit2.http.GET

interface AllService {
    @GET("alieoa/work/all")
    fun getAll():Observable<ArrayList<AllChildBean>>
}