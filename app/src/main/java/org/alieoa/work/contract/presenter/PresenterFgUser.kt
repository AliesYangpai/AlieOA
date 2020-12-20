package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.callback.OnDataBackListener
import org.alieoa.work.contract.UserContract
import org.alieoa.work.universal.db.entity.User
import org.alieoa.work.method.impl.IUserImpl

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述
 * 版本
 */
class PresenterFgUser : BasePresenter<UserContract.IUserView>(), UserContract.IUserPresenter {
    private var mIUser: IUserImpl? = null

    override fun onCreate() {
        super.onCreate()
        mIUser = IUserImpl()
    }

    override fun onDestroy() {
        super.onDestroy()
        mIUser?.clearAllDisposable()
        mIUser = null
    }

    fun doGetUserInfo() {
        mIUser?.getUserInfo(object : OnDataBackListener<User> {
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
                mView.setDataOnUserInfo(t)
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

    fun doGetUserInfoByLambda() {
        mIUser?.getUserInfo({
            mView.showLoadingDialog()
            println("===doGetUserInfoByLambda onStart")
        },
            {
                mView.dismissLoadingDialog()
                println("===doGetUserInfoByLambda onBeforeFinish")
            },
            {
                mView.setDataOnUserInfo(it)
                println("===doGetUserInfoByLambda onSuccess")
            },
            { _, msg ->
                mView.showToast(msg)
                println("===doGetUserInfoByLambda onError:$msg")
            },
            { println("===doGetUserInfoByLambda onFinish") })
    }


}