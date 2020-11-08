package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.constant.ConstLocalData
import org.alieoa.work.contract.WorkChildApproveContract
import org.alieoa.work.method.IApproveImpl

class PresenterFgWorkChildApprove : BasePresenter<WorkChildApproveContract.IWorkChildApproveView>(),
    WorkChildApproveContract.IWorkChildApprovePresenter {


    private var mIApprove: IApproveImpl? = null
    override fun onCreate() {
        super.onCreate()
        mIApprove = IApproveImpl()
    }

    override fun onDestroy() {
        super.onDestroy()
        mIApprove?.clearAllDisposable()
        mIApprove = null
    }

    override fun doGetApproves() {
        mIApprove?.getApproves(
            { mView.showFreshLoading() },
            { mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_1000) },
            { mView.setDataOnApproves(it) },
            { _, msg -> mView.showToast(msg) },
            { println("===doGetApproves onFinish") })
    }

    override fun doGetApprovesByPull() {
        mIApprove?.getApproves({},
            { mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_0) },
            { mView.setDataOnApproves(it) },
            {_,msg->mView.showToast(msg)},
            { println("===doGetApprovesByPull onFinish")})
    }
}