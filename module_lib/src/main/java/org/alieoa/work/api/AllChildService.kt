package org.alieoa.work.api

import org.alieoa.work.entity.AllChildBean
import retrofit2.http.GET

interface AllChildService {
    @GET("alieoa/work/all")
    fun getChildAll():List<AllChildBean>
}