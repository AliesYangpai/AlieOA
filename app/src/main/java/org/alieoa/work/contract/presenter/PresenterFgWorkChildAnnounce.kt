package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.constant.ConstLocalData
import org.alieoa.work.contract.WorkChildAnnounceContract
import org.alieoa.work.method.impl.IAnnounceImpl
import org.alieoa.work.method.impl.IApproveImpl

class PresenterFgWorkChildAnnounce :
    BasePresenter<WorkChildAnnounceContract.IWorkChildAnnounceView>(),
    WorkChildAnnounceContract.IWorkChildAnnouncePresenter {

    private var mIAnnounce: IAnnounceImpl? = null


    override fun onCreate() {
        super.onCreate()
        mIAnnounce = IAnnounceImpl()
    }

    override fun onDestroy() {
        super.onDestroy()
        mIAnnounce?.clearAllDisposable()
        mIAnnounce = null
    }

    /**
     * 获取公告
     */
    override fun doGetAnnounces() {
        mIAnnounce?.getAnnounces({ mView.showFreshLoading() },
            { it -> mView.setDataOnAnnounces(it) },
            { _, msg -> mView.showToast(msg) },
            { mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_1000) })
    }

    override fun doGetAnnouncesByPull() {
        mIAnnounce?.getAnnounces({},
            { it -> mView.setDataOnAnnounces(it) },
            { _, msg -> mView.showToast(msg) },
            { mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_0) })
    }
}