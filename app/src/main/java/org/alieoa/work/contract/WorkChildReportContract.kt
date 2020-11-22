package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract
import org.alieoa.work.entity.ReportBean

interface WorkChildReportContract : IBaseContract {
    interface IWorkChildReportView : IBaseContract.IBaseView {
        fun setDataOnReports(list:ArrayList<ReportBean>)
        fun showFreshLoading()
        fun dismissFreshLoading(delayMillis:Long)
    }
    interface IWorkChildReportPresenter : IBaseContract.IBasePresenter {}
}