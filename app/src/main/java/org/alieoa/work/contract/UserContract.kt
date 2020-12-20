package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract
import org.alieoa.work.universal.db.entity.User

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述W
 * 版本
 */
interface UserContract : IBaseContract {
    interface IUserView : IBaseContract.IBaseView {
        fun setDataOnUserInfo(user: User?)
    }

    interface IUserPresenter : IBaseContract.IBasePresenter {
    }
}