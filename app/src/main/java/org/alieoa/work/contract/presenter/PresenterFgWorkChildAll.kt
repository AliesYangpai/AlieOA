package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.constant.ConstLocalData
import org.alieoa.work.contract.WorkChildAllContract
import org.alieoa.work.method.impl.IAllImpl

class PresenterFgWorkChildAll : BasePresenter<WorkChildAllContract.IWorkChildAllView>(),
    WorkChildAllContract.IWorkChildAllPresenter {
    private var mIAll: IAllImpl? = null
    override fun onCreate() {
        super.onCreate()
        mIAll = IAllImpl()
    }

    override fun onDestroy() {
        super.onDestroy()
        mIAll?.clearAllDisposable()
        mIAll = null
    }

    override fun doGetAllData() {
        mIAll?.getWorkAll({ mView.showFreshLoading() },
            { mView.setDataOnAll(it) },
            { _, msg -> mView.showToast(msg) },
            { mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_1000) })
    }

    override fun doGetAllDataByPull() {
        mIAll?.getWorkAll({ },
            { mView.setDataOnAll(it) },
            { _, msg -> mView.showToast(msg) },
            { mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_0) })
    }

}