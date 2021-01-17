package org.alieoa.work.method.impl

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.alieoa.work.universal.api.ApiHttpClient
import org.alieoa.work.universal.api.service.UserService
import org.alieoa.work.callback.OnDataBackListener
import org.alieoa.work.entity.FrequentContact
import org.alieoa.work.method.IBaseMethod
import org.alieoa.work.method.IUser
import org.alieoa.work.universal.db.entity.User

class IUserImpl : IBaseMethod(), IUser {


    override fun getUserInfo(onDataBackListener: OnDataBackListener<User>) {
        ApiHttpClient.getInstance().generateService(UserService::class.java)?.run {
            getUserInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { onDataBackListener.onFinish() }
                .subscribe({ onDataBackListener.onSuccess(it) },
                    { onDataBackListener.onError(0, it.localizedMessage) },
                    { },
                    {
                        onDataBackListener.onStar()
                        addDisposable(it)
                    })
        }
    }


    override fun getUserInfo(
        onStart: () -> Unit,
        onSuccess: (User) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    ) {
        ApiHttpClient.getInstance().generateService(UserService::class.java)?.run {
            getUserInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { onFinish() }
                .subscribe({ onSuccess.invoke(it) },
                    {
                        onError.invoke(0, it.localizedMessage)
                    }, {}, {
                        onStart.invoke()
                        addDisposable(it)
                    })
        }
    }

    /**
     * 获取常用联系人列表
     */
    override fun getFrequentContacts(
        onStart: () -> Unit,
        onSuccess: (ArrayList<FrequentContact>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    ) {
        ApiHttpClient.getInstance().generateService(UserService::class.java)?.run {
            getUserFrequentContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { onFinish() }
                .subscribe({ onSuccess.invoke(it) },
                    { onError.invoke(0, it.localizedMessage) },
                    { },
                    {
                        onStart.invoke()
                        addDisposable(it)
                    })
        }
    }
}