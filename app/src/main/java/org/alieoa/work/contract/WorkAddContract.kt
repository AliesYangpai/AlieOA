package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract

interface WorkAddContract : IBaseContract {
    interface IWorkAddView : IBaseContract.IBaseView
    interface IWorkAddPresenter : IBaseContract.IBasePresenter
}