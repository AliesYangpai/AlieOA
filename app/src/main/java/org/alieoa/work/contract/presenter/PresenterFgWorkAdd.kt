package org.alieoa.work.contract.presenter

import org.alieoa.basemvp.BasePresenter
import org.alieoa.work.contract.WorkAddContract

class PresenterFgWorkAdd : BasePresenter<WorkAddContract.IWorkAddView>(),
    WorkAddContract.IWorkAddPresenter {
}