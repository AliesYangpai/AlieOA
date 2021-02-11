package org.alieoa.work.ui.fg.work

import android.view.View
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildClientContract
import org.alieoa.work.contract.presenter.PresenterFgChildClient


class WorkChildClientFragment :
    BaseFragment<WorkChildClientContract.IWorkChildClientView, PresenterFgChildClient>(),
    WorkChildClientContract.IWorkChildClientView {
    override fun layoutId(): Int = R.layout.fragment_work_child_client

    override fun initPresenter(): PresenterFgChildClient = PresenterFgChildClient()

    override fun initView(rootView: View) {
       // TODO("Not yet implemented")
    }

    override fun initListener() {
     //   TODO("Not yet implemented")
    }

    override fun onLazyLoad() {
     //   TODO("Not yet implemented")
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
      //  TODO("Not yet implemented")
    }
}