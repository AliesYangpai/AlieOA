package org.alieoa.work.method.impl

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.alieoa.work.entity.ApproveBean
import org.alieoa.work.method.IApprove
import org.alieoa.work.method.IBaseMethod
import org.alieoa.work.universal.api.ApiHttpClient
import org.alieoa.work.universal.api.service.ApproveService

class IApproveImpl : IBaseMethod(), IApprove {
    override fun getApproves(
        onStart: () -> Unit,
        onBeforeFinish: () -> Unit,
        onSuccess: (ArrayList<ApproveBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    ) {
        ApiHttpClient.getInstance().generateService(ApproveService::class.java)?.run {
            getApproves()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { onBeforeFinish.invoke() }
                .subscribe({ onSuccess(it) },
                    { onError(0, it.localizedMessage) },
                    { onFinish() },
                    {
                        onStart()
                        addDisposable(it)
                    })
        }
    }
}