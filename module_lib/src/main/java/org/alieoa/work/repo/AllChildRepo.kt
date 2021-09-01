package org.alieoa.work.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.alieoa.work.source.DataSourceAllChild
import javax.inject.Inject


class AllChildRepo @Inject constructor(val dataSourceAllChild: DataSourceAllChild) {
   suspend fun getAllChildData() {
        dataSourceAllChild.getAllChild()
    }
}