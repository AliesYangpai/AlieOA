package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract
import org.alieoa.work.entity.FrequentContact
import java.util.ArrayList

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述
 * 版本
 */
interface ConnectContract {
    interface IConnectView : IBaseContract.IBaseView {
        fun setDataOnFrequentContacts(it: ArrayList<FrequentContact>?)
        fun setTopViewFocus()
    }

    interface IConnectPresenter : IBaseContract.IBasePresenter {
        fun doGetFrequentContacts()
    }
}