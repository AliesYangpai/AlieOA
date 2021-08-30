package org.alieoa.work.repo

import org.alieoa.work.api.AllChildService
import javax.inject.Inject

class AllChildRepo (val service: AllChildService) {
    fun getAllChildData() {
        service.getChildAll()
    }
}