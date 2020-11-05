package org.alieoa.work.universal.api.service

import io.reactivex.Observable
import org.alieoa.work.entity.ApproveBean
import retrofit2.http.GET

/**
 * 审批的Service
 */
interface ApproveService {
    @GET("alieoa/work/approves")
    fun getApproves():Observable<ArrayList<ApproveBean>>
}