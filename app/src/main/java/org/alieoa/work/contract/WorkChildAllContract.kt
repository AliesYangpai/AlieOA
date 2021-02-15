package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract
import org.alieoa.work.entity.AllChildBean

interface WorkChildAllContract : IBaseContract {
    interface IWorkChildAllView : IBaseContract.IBaseView {
        fun setDataOnAll(list:ArrayList<AllChildBean>)
        fun showFreshLoading()
        fun dismissFreshLoading(delayMillis:Long) // 首次进入界面的延迟收缩特效
    }
    interface IWorkChildAllPresenter : IBaseContract.IBasePresenter {
        fun doGetAllData()
        fun doGetAllDataByPull()
    }
}