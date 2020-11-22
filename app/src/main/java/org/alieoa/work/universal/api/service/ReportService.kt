package org.alieoa.work.universal.api.service

import io.reactivex.Observable
import org.alieoa.work.entity.ReportBean
import retrofit2.http.GET

interface ReportService {
    @GET("alieoa/work/reports")
    fun getReports():Observable<ArrayList<ReportBean>>
}