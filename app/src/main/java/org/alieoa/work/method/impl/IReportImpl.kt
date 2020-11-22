package org.alieoa.work.method.impl

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.alieoa.work.entity.ReportBean
import org.alieoa.work.method.IBaseMethod
import org.alieoa.work.method.IReport
import org.alieoa.work.universal.api.ApiHttpClient
import org.alieoa.work.universal.api.service.ReportService

/**
 * 方法实现类
 */
class IReportImpl : IBaseMethod(), IReport {
    override fun getReports(
        onStart: () -> Unit,
        onBeforeFinish: () -> Unit,
        onSuccess: (ArrayList<ReportBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    ) {
        ApiHttpClient.getInstance().generateService(ReportService::class.java)?.run {
            getReports()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { onBeforeFinish.invoke() }
                .subscribe({ onSuccess(it) },
                    { onError(0, it.localizedMessage) },
                    { onFinish() },
                    { onStart()
                    addDisposable(it) })
        }
    }
}