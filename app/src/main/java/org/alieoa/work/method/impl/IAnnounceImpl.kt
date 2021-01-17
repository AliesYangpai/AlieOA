package org.alieoa.work.method.impl

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.alieoa.work.entity.AnnounceBean
import org.alieoa.work.method.IAnnounce
import org.alieoa.work.method.IBaseMethod
import org.alieoa.work.universal.api.ApiHttpClient
import org.alieoa.work.universal.api.service.AnnounceService

class IAnnounceImpl : IBaseMethod(), IAnnounce {
    override fun getAnnounces(
        onStart: () -> Unit,
        onSuccess: (ArrayList<AnnounceBean>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    ) {
        ApiHttpClient.getInstance().generateService(AnnounceService::class.java)?.run {
            getAnnounces().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { onFinish() }
                .subscribe(
                    { onSuccess(it) },
                    { onError(0, it.localizedMessage) },
                    { },
                    {
                        onStart()
                        addDisposable(it)
                    })
        }
    }
}