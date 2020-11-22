package org.alieoa.work.ui.fg.work

import android.view.View
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildAllContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildAll


/**
 * 全部界面
 */
class WorkChildAllFragment :
    BaseFragment<WorkChildAllContract.IWorkChildAllView, PresenterFgWorkChildAll>(),
    WorkChildAllContract.IWorkChildAllView {

    override fun layoutId(): Int = R.layout.fragment_work_child_all

    override fun initPresenter(): PresenterFgWorkChildAll = PresenterFgWorkChildAll()

    override fun initView(rootView: View) {
    }

    override fun initListener() {
    }

    override fun onLazyLoad() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }
}