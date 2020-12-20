package org.alieoa.work.universal.api.service

import io.reactivex.Observable
import org.alieoa.work.entity.AnnounceBean
import retrofit2.http.GET

/**
 * 公告的接口
 */
interface AnnounceService {
    @GET("alieoa/work/announces")
    fun getAnnounces():Observable<ArrayList<AnnounceBean>>
}