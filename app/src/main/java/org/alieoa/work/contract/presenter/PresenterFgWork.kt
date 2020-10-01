package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.contract.ChatMsgContract
import org.alieoa.work.contract.WorkContract
import org.alieoa.work.method.IUser
import org.alieoa.work.method.IUserImpl

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述
 * 版本
 */
class PresenterFgWork : BasePresenter<WorkContract.IWorkView>(),
    WorkContract.IWorkPresenter {
}