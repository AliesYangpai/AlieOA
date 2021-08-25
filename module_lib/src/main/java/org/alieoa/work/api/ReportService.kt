package org.alieoa.work.api

import retrofit2.http.GET

interface ReportService {
    @GET("alieoa/work/reports")
    fun getReports()
}
