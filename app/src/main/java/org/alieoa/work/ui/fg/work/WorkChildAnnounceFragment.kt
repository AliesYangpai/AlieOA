package org.alieoa.work.ui.fg.work

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildAnnounceContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildAnnounce
import kotlinx.android.synthetic.main.fragment_work_child_announce.*
import org.alieoa.work.entity.AnnounceBean
import org.alieoa.work.ui.adapter.WorkChildAnnounceAdapter

/**
 * 公告的fragment
 */
class WorkChildAnnounceFragment :
    BaseFragment<WorkChildAnnounceContract.IWorkChildAnnounceView, PresenterFgWorkChildAnnounce>(),
    WorkChildAnnounceContract.IWorkChildAnnounceView {

    lateinit var mWorkChildAnnounceAdapter: WorkChildAnnounceAdapter
    override fun layoutId(): Int = R.layout.fragment_work_child_announce
    override fun initPresenter(): PresenterFgWorkChildAnnounce = PresenterFgWorkChildAnnounce()

    override fun initView(rootView: View) {
        mSrlFresh.apply {
            setColorSchemeColors(*getSwipeRefreshColor())
            setOnRefreshListener {
                mPresenter?.doGetAnnouncesByPull()
            }
        }

        mRvList.apply {
            mWorkChildAnnounceAdapter = WorkChildAnnounceAdapter()
            layoutManager = LinearLayoutManager(mActivity)
            adapter = mWorkChildAnnounceAdapter
        }
    }

    override fun initListener() {
        mWorkChildAnnounceAdapter.setOnItemClick { announceBean, i ->
            showToast(announceBean.author!!)
        }
    }

    override fun onLazyLoad() {
        mPresenter?.doGetAnnounces()
    }

    override fun setDataOnAnnounces(list: ArrayList<AnnounceBean>) {
        mWorkChildAnnounceAdapter.mData = list
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
        showToast(errorMsg)
    }

}