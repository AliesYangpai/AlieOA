package org.alieoa.work.method

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.alieoa.work.api.ApiHttpClient
import org.alieoa.work.api.UserService
import org.alieoa.work.callback.OnDataBackListener
import org.alieoa.work.db.entity.User

class IUserImpl : IBaseMethod(), IUser {


    override fun getUserInfo(onDataBackListener: OnDataBackListener<User>) {
        ApiHttpClient.getInstance().generateService(UserService::class.java)?.run {
            getUserInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { onDataBackListener.onBeforeFinish() }
                .subscribe({ onDataBackListener.onSuccess(it) },
                    { onDataBackListener.onError(0, it.localizedMessage) },
                    { onDataBackListener.onFinish() },
                    {
                        onDataBackListener.onStar()
                        addDisposable(it)
                    })
        }
    }


    override fun getUserInfo(
        onStart: () -> Unit,
        onBeforeFinish: () -> Unit,
        onSuccess: (User) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    ) {
        ApiHttpClient.getInstance().generateService(UserService::class.java)?.run {
            getUserInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { onBeforeFinish.invoke() }
                .subscribe({
                    onSuccess.invoke(it)
                },{
                    onError.invoke(0,it.localizedMessage)
                },{
                    onFinish.invoke()
                },{
                    onStart.invoke()
                    addDisposable(it)
                })
        }
    }
}