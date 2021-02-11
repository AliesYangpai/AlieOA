package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract
import org.alieoa.work.entity.ClientBean

interface WorkChildClientContract : IBaseContract {
    interface IWorkChildClientView : IBaseContract.IBaseView {
        fun showFreshLoading()
        fun dismissFreshLoading(delayMillis: Long) // 首次进入界面的延迟收缩特效
        fun setDataOnClients(list: ArrayList<ClientBean>) // 设置clients列表
    }

    interface IWorkChildClientPresenter : IBaseContract.IBasePresenter {
        fun doGetClients()
        fun doGetClientsByPull()
    }
}