package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract
import org.alieoa.work.entity.AnnounceBean

interface WorkChildAnnounceContract : IBaseContract {
    interface IWorkChildAnnounceView : IBaseContract.IBaseView {
        fun setDataOnAnnounces(list:ArrayList<AnnounceBean>)
        fun showFreshLoading()
        fun dismissFreshLoading(delayMillis:Long) // 首次进入界面的延迟收缩特效

    }
    interface IWorkChildAnnouncePresenter : IBaseContract.IBasePresenter {
        fun doGetAnnounces()
        fun doGetAnnouncesByPull()
    }
}