package org.alieoa.work.ui.fg.work

import androidx.fragment.app.Fragment
import android.view.View
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildReportContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildReport


/**
 * A simple [Fragment] subclass.
 * Use the [WorkChildReportFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkChildReportFragment :
    BaseFragment<WorkChildReportContract.IWorkChildReportView, PresenterFgWorkChildReport>(),
    WorkChildReportContract.IWorkChildReportView {
    override fun layoutId(): Int = R.layout.fragment_work_child_report

    override fun initPresenter(): PresenterFgWorkChildReport = PresenterFgWorkChildReport()

    override fun initView(rootView: View) {
        //    TODO("Not yet implemented")
    }

    override fun initListener() {
        //  TODO("Not yet implemented")
    }

    override fun onLazyLoad() {
        //  TODO("Not yet implemented")
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
        //  TODO("Not yet implemented")
    }
}