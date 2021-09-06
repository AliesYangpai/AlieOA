package org.alieoa.work.api

import org.alieoa.work.entity.*
import retrofit2.http.GET

/**
 * WorkSection相关服务
 */
interface WorkSectionService {
    @GET("alieoa/work/all")
    suspend fun getAllWorkSections(): List<WorkSectionAll>

    @GET("alieoa/work/reports")
    suspend fun getReportWorkSections(): List<WorkSectionReport>?

    @GET("alieoa/work/clients")
    suspend fun getClientWorkSections(): List<WorkSectionClient>?

    @GET("alieoa/work/approves")
    suspend fun getApproveWorkSections(): List<WorkSectionApprove>?

    @GET("alieoa/work/announces")
    suspend fun getAnnounceWorkSections(): List<WorkSectionAnnounce>?
}