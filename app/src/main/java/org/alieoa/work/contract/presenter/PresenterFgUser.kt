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
    var iUser:IUser?= null

    override fun onCreate() {
        super.onCreate()
        iUser = IUserImpl()
    }

    fun doGetUserInfo() {
        iUser?.getUserInfo( object : OnDataBackListener<User> {
            override fun onStar() {
//                TODO("Not yet implemented")
            }

            override fun onSuccess(t: User) {
//                TODO("Not yet implemented")
            }

            override fun onError(code: Int, msg: String) {
//                TODO("Not yet implemented")
            }

            override fun onFinish() {
//                TODO("Not yet implemented")
            }

        })
    }
}