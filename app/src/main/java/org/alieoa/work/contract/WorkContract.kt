package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述W
 * 版本
 */
interface WorkContract : IBaseContract {
    interface IWorkView : IBaseContract.IBaseView {
    }

    interface IWorkPresenter : IBaseContract.IBasePresenter {
    }
}