package org.alieoa.work.ui.fg.work

import android.view.View
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildReportContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildReport
import kotlinx.android.synthetic.main.fragment_work_child_report.*

/**
 * 汇报的fragment
 */
class WorkChildReportFragment :
    BaseFragment<WorkChildReportContract.IWorkChildReportView, PresenterFgWorkChildReport>(),
    WorkChildReportContract.IWorkChildReportView {
    override fun layoutId(): Int = R.layout.fragment_work_child_report

    override fun initPresenter(): PresenterFgWorkChildReport = PresenterFgWorkChildReport()

    override fun initView(rootView: View) {
        mSrlFresh.apply {
            setColorSchemeColors(*getSwipeRefreshColor())
            setOnRefreshListener{
                // TODO
            }
        }
        mRvList.apply {

        }
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