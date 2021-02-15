package org.alieoa.work.ui.fg.work

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildAllContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildAll
import kotlinx.android.synthetic.main.fragment_work_child_all.*
import org.alieoa.work.entity.AllChildBean
import org.alieoa.work.ui.adapter.WorkChildAllAdapter

/**
 * 全部界面
 */
class WorkChildAllFragment :
    BaseFragment<WorkChildAllContract.IWorkChildAllView, PresenterFgWorkChildAll>(),
    WorkChildAllContract.IWorkChildAllView {

    private lateinit var mWorkChildAllAdapter: WorkChildAllAdapter
    override fun layoutId(): Int = R.layout.fragment_work_child_all

    override fun initPresenter(): PresenterFgWorkChildAll = PresenterFgWorkChildAll()

    override fun initView(rootView: View) {
        mSrlFresh.apply {
            setColorSchemeColors(*getSwipeRefreshColor())
            setOnRefreshListener {
                mPresenter?.doGetAllDataByPull()
            }
        }
        mRvList.apply {
            mWorkChildAllAdapter = WorkChildAllAdapter()
            layoutManager = LinearLayoutManager(mActivity)
            adapter = mWorkChildAllAdapter
        }
    }

    override fun initListener() {

    }

    override fun onLazyLoad() {
        mPresenter?.doGetAllData()
    }

    override fun setDataOnAll(list: ArrayList<AllChildBean>) {
        mWorkChildAllAdapter.mData = list
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
    }
}