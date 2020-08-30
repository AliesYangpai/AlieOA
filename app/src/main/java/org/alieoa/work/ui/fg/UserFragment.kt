package org.alieoa.work.ui.fg


import android.view.View
import org.alieoa.basemvp.BaseFragment

import org.alieoa.work.R
import org.alieoa.work.contract.UserContract
import org.alieoa.work.contract.presenter.PresenterFgUser

class UserFragment : BaseFragment<UserContract.IUserView, PresenterFgUser>(),
    UserContract.IUserView {



    override fun layoutId(): Int {
        return R.layout.fragment_user
    }

    override fun initPresenter(): PresenterFgUser {
        return PresenterFgUser()
    }

    override fun initView(rootView: View) {
    }

    override fun initListener() {
    }

    override fun onLazyLoad() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }

}