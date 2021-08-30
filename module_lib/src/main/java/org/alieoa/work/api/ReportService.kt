package org.alieoa.work.api

import org.alieoa.work.entity.ReportBean
import retrofit2.http.GET

interface ReportService {
    @GET("alieoa/work/reports")
    fun getReports():List<ReportBean>?
}
