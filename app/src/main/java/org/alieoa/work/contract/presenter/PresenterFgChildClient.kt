package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.constant.ConstLocalData
import org.alieoa.work.contract.WorkChildClientContract
import org.alieoa.work.method.IClient
import org.alieoa.work.method.impl.IClientImpl

class PresenterFgChildClient : BasePresenter<WorkChildClientContract.IWorkChildClientView>(),
    WorkChildClientContract.IWorkChildClientPresenter {
    private var mIClient: IClientImpl? = null
    override fun onCreate() {
        super.onCreate()
        mIClient = IClientImpl()
    }

    override fun onDestroy() {
        super.onDestroy()
        mIClient?.clearAllDisposable()
        mIClient = null
    }

    override fun doGetClients() {
        mIClient?.getClients(
            { mView.showFreshLoading() },
            {it->mView.setDataOnClients(it)},
            { _, msg -> mView.showToast(msg) },
            { mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_1000) })
    }

    override fun doGetClientsByPull() {
       mIClient?.getClients(
           {mView.showFreshLoading()},
           {it->mView.setDataOnClients(it)},
           {_,msg->mView.showToast(msg)},
           {mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_0)})
    }
}