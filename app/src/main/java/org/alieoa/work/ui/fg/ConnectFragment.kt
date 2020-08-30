package org.alieoa.work.ui.fg


import android.view.View
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R

import org.alieoa.work.contract.ConnectContract
import org.alieoa.work.contract.presenter.PresenterFgConnect


class ConnectFragment : BaseFragment<ConnectContract.IConnectView, PresenterFgConnect>(),
    ConnectContract.IConnectView {

    override fun layoutId(): Int {
        return R.layout.fragment_connect
    }

    override fun initPresenter(): PresenterFgConnect {
       return PresenterFgConnect()
    }

    override fun initView(rootView: View) {

    }

    override fun initListener() {
    }


    override fun onLazyLoad() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }

//R.layout.fragment_connect

}
