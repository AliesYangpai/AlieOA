package org.alieoa.work.universal.api.service

import io.reactivex.Observable
import org.alieoa.work.entity.AnnounceBean
import retrofit2.http.GET

/**
 * 公告的接口Service：
 * RxJava网络封装逻辑：
 * 1.原生Action onComplete此处不做任何处理
 * 2.使用“功能操作符”doAfterTerminate来完成对上层请求结束的回调 【原因是，原生的onComplete与onError互斥，本请求逻辑的封装】
 */
interface AnnounceService {
    @GET("alieoa/work/announces")
    fun getAnnounces():Observable<ArrayList<AnnounceBean>>
}