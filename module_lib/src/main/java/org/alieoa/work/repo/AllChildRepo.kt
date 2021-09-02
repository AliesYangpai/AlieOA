package org.alieoa.work.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.alieoa.work.api.AllChildService
import org.alieoa.work.entity.AllChildBean
import javax.inject.Inject


class AllChildRepo @Inject constructor(private val service: AllChildService) {
    suspend fun getAllChildData(): Result<List<AllChildBean>> =
        try {
            withContext(Dispatchers.IO) { service.getChildAll() }.let {
                Result.success(it)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
}