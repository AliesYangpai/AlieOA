package org.alieoa.work.ui.fg.work

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildApproveContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildApprove
import kotlinx.android.synthetic.main.fragment_work_child_approve.*
import org.alieoa.work.entity.ApproveBean
import org.alieoa.work.ui.adapter.WorkChildApproveAdapter

class WorkChildApproveFragment :
    BaseFragment<WorkChildApproveContract.IWorkChildApproveView, PresenterFgWorkChildApprove>(),
    WorkChildApproveContract.IWorkChildApproveView {

    private lateinit var mWorkChildApproveAdapter: WorkChildApproveAdapter

    override fun layoutId(): Int = R.layout.fragment_work_child_approve

    override fun initPresenter(): PresenterFgWorkChildApprove = PresenterFgWorkChildApprove()

    override fun initView(rootView: View) {
        mSrlFresh.apply {
            setColorSchemeColors(*getSwipeRefreshColor())
            setOnRefreshListener {
                mPresenter?.doGetApprovesByPull()
            }
        }
        mRvList.apply {
            mWorkChildApproveAdapter = WorkChildApproveAdapter()
            layoutManager = LinearLayoutManager(mActivity)
            adapter = mWorkChildApproveAdapter
        }
    }

    override fun initListener() {
        mWorkChildApproveAdapter.setOnItemClick { approveBean, _ ->
            showToast(approveBean.approveName!!)
        }
    }

    override fun onLazyLoad() {
        mPresenter?.doGetApproves()
    }

    override fun setDataOnApproves(list: ArrayList<ApproveBean>) {
        mWorkChildApproveAdapter.mData = list
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
        //   TODO("Not yet implemented")
    }
}