package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.callback.OnDataBackListener
import org.alieoa.work.contract.UserContract
import org.alieoa.work.db.entity.User
import org.alieoa.work.method.IUser
import org.alieoa.work.method.IUserImpl

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述
 * 版本
 */
class PresenterFgUser : BasePresenter<UserContract.IUserView>(), UserContract.IUserPresenter {
    private var iUser:IUserImpl?= null

    override fun onCreate() {
        super.onCreate()
        iUser = IUserImpl()
    }

    override fun onDestroy() {
        super.onDestroy()
        iUser?.clearAllDisposable()
        iUser = null
    }

    fun doGetUserInfo() {
        iUser?.getUserInfo(object : OnDataBackListener<User> {
            override fun onStar() {
                mView.showLoadingDialog()
                println("====doGetUserInfo() start")
            }

            override fun onBeforeFinish() {
                mView.dismissLoadingDialog()
                println("====onBeforeResult() start")
            }

            override fun onSuccess(t: User) {
                mView.showToast(t.toString())
                println("====doGetUserInfo() onSuccess $t")
            }

            override fun onError(code: Int, msg: String) {
                println("====doGetUserInfo() onError")
                mView.showToast(msg)
            }

            override fun onFinish() {
                println("====doGetUserInfo() onFinish")
            }
        })
    }


}