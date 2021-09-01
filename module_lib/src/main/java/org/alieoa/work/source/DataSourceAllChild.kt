package org.alieoa.work.source

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.alieoa.work.api.AllChildService
import javax.inject.Inject

/**
 * 数据源：
 * 目的是为了封装返回速率就
 * @property service AllChildService
 * @constructor
 */
class DataSourceAllChild @Inject constructor(val service: AllChildService) {
    suspend fun getAllChild() {
         withContext(Dispatchers.IO) {
             service.getChildAll()
         }
    }
}