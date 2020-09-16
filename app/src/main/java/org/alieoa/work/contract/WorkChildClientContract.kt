package org.alieoa.work.contract

import org.alieoa.basemvp.IBaseContract

interface WorkChildClientContract : IBaseContract {
    interface IWorkChildClientView : IBaseContract.IBaseView {}
    interface IWorkChildClientPresenter : IBaseContract.IBasePresenter {}
}