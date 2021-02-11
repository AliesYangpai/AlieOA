package org.alieoa.work.ui.fg.work

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_work_child_client.*
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildClientContract
import org.alieoa.work.contract.presenter.PresenterFgChildClient
import org.alieoa.work.entity.ClientBean
import org.alieoa.work.ui.adapter.WorkChildClientAdapter

class WorkChildClientFragment :
    BaseFragment<WorkChildClientContract.IWorkChildClientView, PresenterFgChildClient>(),
    WorkChildClientContract.IWorkChildClientView {

    private lateinit var mWorkChildClientAdapter: WorkChildClientAdapter

    override fun layoutId(): Int = R.layout.fragment_work_child_client

    override fun initPresenter(): PresenterFgChildClient = PresenterFgChildClient()

    override fun initView(rootView: View) {
        mSrlFresh.apply {
            setColorSchemeColors(*getSwipeRefreshColor())
            setOnRefreshListener {
                mPresenter?.doGetClientsByPull()
            }
        }
        mRvList.apply {
            mWorkChildClientAdapter = WorkChildClientAdapter()
            layoutManager = LinearLayoutManager(mActivity)
            adapter = mWorkChildClientAdapter
        }
    }

    override fun initListener() {
        mWorkChildClientAdapter.setOnItemClick { clientBean, i -> showToast(clientBean.name + " position:" + i) }
    }

    override fun onLazyLoad() {
        mPresenter?.doGetClients()
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

    override fun setDataOnClients(list: ArrayList<ClientBean>) {
       mWorkChildClientAdapter.mData = list
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
        //  TODO("Not yet implemented")
    }
}