package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.contract.ConnectContract
import org.alieoa.work.method.impl.IUserImpl

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述
 * 版本
 */
class PresenterFgConnect : BasePresenter<ConnectContract.IConnectView>(),
    ConnectContract.IConnectPresenter {

    var mIUser: IUserImpl? = null
    override fun onCreate() {
        super.onCreate()
        mIUser = IUserImpl()
    }

    override fun onDestroy() {
        mIUser?.clearAllDisposable()
        mIUser = null
        super.onDestroy()
    }

    override fun doGetFrequentContacts() {
        mIUser?.getFrequentContacts(
            { mView.showLoadingDialog() },
            { it -> mView.setDataOnFrequentContacts(it) },
            { _, msg -> mView.showToast(msg) },
            { mView.dismissLoadingDialog() })
    }

}