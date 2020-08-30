package org.alieoa.work.ui.fg


import android.view.View
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R

import org.alieoa.work.contract.WorkContract
import org.alieoa.work.contract.presenter.PresenterFgWork

class WorkFragment : BaseFragment<WorkContract.IWorkView, PresenterFgWork>(),
    WorkContract.IWorkView {

    override fun layoutId(): Int {
        return R.layout.fragment_work
    }

    override fun initPresenter(): PresenterFgWork {
        return PresenterFgWork()
    }

    override fun initView(rootView: View) {
    }

    override fun initListener() {
    }

    override fun onLazyLoad() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }


}
