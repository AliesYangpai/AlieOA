package org.alieoa.work.ui.fg.work

import android.view.View
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildApproveContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildApprove
class FragmentWorkChildApprove :
    BaseFragment<WorkChildApproveContract.IWorkChildApproveView, PresenterFgWorkChildApprove>(),
    WorkChildApproveContract.IWorkChildApproveView {
    override fun layoutId(): Int = R.layout.fragment_work_child_approve
    override fun initPresenter(): PresenterFgWorkChildApprove = PresenterFgWorkChildApprove()
    override fun initView(rootView: View) {
        //   TODO("Not yet implemented")
    }

    override fun initListener() {
        //   TODO("Not yet implemented")
    }

    override fun onLazyLoad() {
        //    TODO("Not yet implemented")
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
        //   TODO("Not yet implemented")
    }
}