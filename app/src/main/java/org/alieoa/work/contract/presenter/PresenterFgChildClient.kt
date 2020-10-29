package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.contract.WorkChildClientContract

class PresenterFgChildClient : BasePresenter<WorkChildClientContract.IWorkChildClientView>(),
    WorkChildClientContract.IWorkChildClientPresenter {
}