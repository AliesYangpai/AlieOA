package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述W
 * 版本
 */
interface UserContract : IBaseContract {
    interface IUserView : IBaseContract.IBaseView {
    }

    interface IUserPresenter : IBaseContract.IBasePresenter {
    }
}