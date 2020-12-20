package org.alieoa.work.ui.fg.work

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildReportContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildReport
import kotlinx.android.synthetic.main.fragment_work_child_report.*
import org.alieoa.work.entity.ReportBean
import org.alieoa.work.ui.adapter.WorkChildReportAdapter

/**
 * 汇报的fragment
 */
class WorkChildReportFragment :
    BaseFragment<WorkChildReportContract.IWorkChildReportView, PresenterFgWorkChildReport>(),
    WorkChildReportContract.IWorkChildReportView {

    private lateinit var mWorkChildReportAdapter: WorkChildReportAdapter

    override fun layoutId(): Int = R.layout.fragment_work_child_report

    override fun initPresenter(): PresenterFgWorkChildReport = PresenterFgWorkChildReport()

    override fun initView(rootView: View) {
        mSrlFresh.apply {
            setColorSchemeColors(*getSwipeRefreshColor())
            setOnRefreshListener {
                mPresenter?.doGetReportsByPull()
            }
        }
        mRvList.apply {
            mWorkChildReportAdapter = WorkChildReportAdapter()
            layoutManager = LinearLayoutManager(mActivity)
            adapter = mWorkChildReportAdapter;
        }
    }

    override fun initListener() {
        mWorkChildReportAdapter.setOnItemClick { reportBean, _ ->
            showToast(reportBean.name!!)
        }
    }

    override fun onLazyLoad() {
        mPresenter?.doGetReports()
    }

    override fun setDataOnReports(list: ArrayList<ReportBean>) {
        mWorkChildReportAdapter.mData = list
    }

    override fun showFreshLoading() {
        mSrlFresh.isRefreshing = true
    }

    override fun dismissFreshLoading(delayMillis: Long) {
        mSrlFresh.apply {
            if (isRefreshing) {
                postDelayed({ isRefreshing = false }, delayMillis)
            }
        }
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
        //  TODO("Not yet implemented")
    }
}