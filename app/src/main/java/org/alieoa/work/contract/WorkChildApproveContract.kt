package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract
import org.alieoa.work.entity.ApproveBean

interface WorkChildApproveContract : IBaseContract {
    interface IWorkChildApproveView : IBaseContract.IBaseView {
        fun setDataOnApproves(list:ArrayList<ApproveBean>)
        fun showFreshLoading()
        fun dismissFreshLoading(delayMillis:Long)
    }
    interface IWorkChildApprovePresenter : IBaseContract.IBasePresenter {
        fun doGetApproves()
        fun doGetApprovesByPull()
    }
}