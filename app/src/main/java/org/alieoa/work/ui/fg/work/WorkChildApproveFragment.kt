package org.alieoa.work.ui.fg.work

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildApproveContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildApprove
import kotlinx.android.synthetic.main.fragment_work_child_approve.*
import org.alieoa.work.test.TestValue
import org.alieoa.work.ui.adapter.WorkChildApproveAdapter

class FragmentWorkChildApprove :
    BaseFragment<WorkChildApproveContract.IWorkChildApproveView, PresenterFgWorkChildApprove>(),
    WorkChildApproveContract.IWorkChildApproveView {

    private lateinit var mWorkChildApproveAdapter: WorkChildApproveAdapter

    override fun layoutId(): Int = R.layout.fragment_work_child_approve

    override fun initPresenter(): PresenterFgWorkChildApprove = PresenterFgWorkChildApprove()

    override fun initView(rootView: View) {
        mSrlFresh.setColorSchemeColors(*getSwipeRefreshColor())
        mRvList.apply {
            mWorkChildApproveAdapter = WorkChildApproveAdapter(R.layout.item_fg_work_child_approve)
            layoutManager = LinearLayoutManager(mActivity)
            adapter = mWorkChildApproveAdapter
        }
    }

    override fun initListener() {
        mSrlFresh.setOnRefreshListener {
            showToast("下拉刷新")
        }
    }

    override fun onLazyLoad() {
        mWorkChildApproveAdapter.mData = TestValue.getApproveList()
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
        //   TODO("Not yet implemented")
    }
}