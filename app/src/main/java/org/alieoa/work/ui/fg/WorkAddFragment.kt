package org.alieoa.work.ui.fg

import android.view.View
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkAddContract
import org.alieoa.work.contract.presenter.PresenterFgWorkAdd


class WorkAddFragment : BaseFragment<WorkAddContract.IWorkAddView, PresenterFgWorkAdd>(),
    WorkAddContract.IWorkAddView {
    override fun layoutId(): Int = R.layout.fragment_work_add

    override fun initPresenter(): PresenterFgWorkAdd = PresenterFgWorkAdd()

    override fun initView(rootView: View) {
    }

    override fun initListener() {
    }

    override fun onLazyLoad() {
    }

    override fun showToast(msg: String, duration: Int) {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }

}