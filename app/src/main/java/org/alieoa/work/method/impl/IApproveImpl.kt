package org.alieoa.work.method.impl

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.alieoa.work.entity.AnnounceBean
import org.alieoa.work.entity.ApproveBean
import org.alieoa.work.method.IApprove
import org.alieoa.work.method.IBaseMethod
import org.alieoa.work.universal.api.ApiHttpClient
import org.alieoa.work.universal.api.service.ApproveService

class IApproveImpl : IBaseMethod(), IApprove {

    companion object {
        const val TAG = "IApproveImpl";
    }
    override fun getApproves(
        onStart: () -> Unit,
        onSuccess: (ArrayList<ApproveBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    ) {
        ApiHttpClient.getInstance().generateService(ApproveService::class.java)?.run {
            getApproves()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate {
                    Log.d(TAG,"===getApproves doAfterTerminate")
                    onFinish() }
                .subscribe({
                    Log.d(TAG,"===getApproves onSuccess")
                    onSuccess(it) },
                    {
                        Log.d(TAG,"===getApproves onError")
                        onError(0, it.localizedMessage) },
                    {
                        Log.d(TAG,"===getApproves ~~ignore~~ raw onComplete,no upper method invoke")
                    },
                    {
                        Log.d(TAG,"===getApproves onStart")
                        onStart()
                        addDisposable(it)
                    })
        }
    }
}