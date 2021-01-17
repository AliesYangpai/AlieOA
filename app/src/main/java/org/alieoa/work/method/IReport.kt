package org.alieoa.work.method

import org.alieoa.work.entity.ReportBean

interface IReport {
    fun getReports(
        onStart: () -> Unit,
        onSuccess: (ArrayList<ReportBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    )
}