package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.constant.ConstLocalData
import org.alieoa.work.contract.WorkChildReportContract
import org.alieoa.work.method.impl.IReportImpl

class PresenterFgWorkChildReport : BasePresenter<WorkChildReportContract.IWorkChildReportView>(),
    WorkChildReportContract.IWorkChildReportPresenter {

    var mIReport: IReportImpl? = null

    override fun onCreate() {
        super.onCreate()
        mIReport = IReportImpl()
    }

    fun doGetReports() {
        mIReport?.getReports({ mView.showFreshLoading() },
            {it-> mView.setDataOnReports(it)},
            {_,msg->mView.showToast(msg)},
            {mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_1000)})
    }

    fun doGetReportsByPull() {
        mIReport?.getReports({},
            {it-> mView.setDataOnReports(it)},
            {_,msg->mView.showToast(msg)},
            {mView.dismissFreshLoading(ConstLocalData.DELAY_MILLIS_0)})
    }
}