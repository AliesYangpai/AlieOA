package org.alieoa.work.method.impl

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.alieoa.work.entity.ClientBean
import org.alieoa.work.method.IBaseMethod
import org.alieoa.work.method.IClient
import org.alieoa.work.universal.api.ApiHttpClient
import org.alieoa.work.universal.api.service.ClientService

class IClientImpl : IBaseMethod(), IClient {
    companion object {
        const val TAG = "IClientImpl"
    }

    override fun getClients(
        onStart: () -> Unit,
        onSuccess: (ArrayList<ClientBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    ) {
        ApiHttpClient.getInstance().generateService(ClientService::class.java)?.run {
            getClients()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate {
                    Log.d(TAG, "===getClients doAfterTerminate")
                    onFinish()
                }
                .subscribe(
                    {
                        Log.d(TAG, "===getClients onSuccess")
                        onSuccess(it)
                    },
                    {
                        Log.d(TAG, "===getClients onError")
                        onError(0, it.localizedMessage)
                    }, {},
                    {
                        Log.d(TAG, "===getClients onStart")
                        onStart()
                        addDisposable(it)
                    })
        }
    }
}