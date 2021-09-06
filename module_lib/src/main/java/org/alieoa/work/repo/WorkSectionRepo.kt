package org.alieoa.work.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.alieoa.work.api.WorkSectionService
import org.alieoa.work.entity.WorkSectionAll
import javax.inject.Inject


class WorkSectionRepo @Inject constructor(val service: WorkSectionService) {
    suspend fun getAllWorkSectionData(): Result<List<WorkSectionAll>> =
        try {
            withContext(Dispatchers.IO) { service.getAllWorkSections() }.let {
                Result.success(it)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
}