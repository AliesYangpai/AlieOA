package org.alieoa.work.method.impl

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.alieoa.work.entity.AllChildBean
import org.alieoa.work.method.IAll
import org.alieoa.work.method.IBaseMethod
import org.alieoa.work.universal.api.ApiHttpClient
import org.alieoa.work.universal.api.service.AllService

class IAllImpl : IBaseMethod(), IAll {
    override fun getWorkAll(
        onStart: () -> Unit,
        onSuccess: (ArrayList<AllChildBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    ) {
        ApiHttpClient.getInstance().generateService(AllService::class.java)?.run {
            getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { onFinish() }
                .subscribe({ onSuccess(it) },
                    { onError(0, it.localizedMessage) },
                    {},
                    {
                        onStart()
                        addDisposable(it)
                    })
        }
    }
}