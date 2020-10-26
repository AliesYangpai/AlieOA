package org.alieoa.work.ui.fg


import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import butterknife.BindView
import butterknife.OnClick
import com.google.android.material.tabs.TabLayout
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.constant.ConstLocalData

import org.alieoa.work.contract.WorkContract
import org.alieoa.work.contract.presenter.PresenterFgWork
import org.alieoa.work.ui.activity.WorkAddActivity

class WorkFragment : BaseFragment<WorkContract.IWorkView, PresenterFgWork>(),
    WorkContract.IWorkView,
    TabLayout.OnTabSelectedListener {

    private lateinit var mNavControllerWorkChild: NavController

    @BindView(R.id.tv_left)
    lateinit var mTvLeft: TextView

    @BindView(R.id.iv_right)
    lateinit var mIvRight: ImageView

    @BindView(R.id.tbl_work_child)
    lateinit var mTblWorkChild: TabLayout

    @BindView(R.id.iv_add)
    lateinit var mIvAdd: ImageView


    @OnClick(
        R.id.iv_right,
        R.id.iv_add
    )
    fun onClick(view: View) {
        when (view.id) {
            R.id.iv_right ->
                Toast.makeText(mActivity.applicationContext, "iv_right", Toast.LENGTH_SHORT).show()
            R.id.iv_add -> startActivity(Intent().also {
                it.setClass(
                    mActivity,
                    WorkAddActivity::class.java
                )
            })

        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_work
    }

    override fun initPresenter(): PresenterFgWork {
        return PresenterFgWork()
    }

    override fun initView(rootView: View) {
        mNavControllerWorkChild = mActivity.findNavController(R.id.fg_work_child_container)

        mTblWorkChild.let {
            it.addOnTabSelectedListener(this)
            it.addTab(it.newTab().setText(getString(R.string.work_all)))
            it.addTab(it.newTab().setText(getString(R.string.approve)))
            it.addTab(it.newTab().setText(getString(R.string.work_report)))
            it.addTab(it.newTab().setText(getString(R.string.work_client)))
            it.addTab(it.newTab().setText(getString(R.string.work_notice)))
        }



    }


    override fun initListener() {

    }

    override fun onLazyLoad() {
        mTblWorkChild.getTabAt(ConstLocalData.TAB_INDEX_0)?.select()
    }

    override fun showToast(msg: String, duration: Int) {
        Toast.makeText(mActivity.applicationContext, msg, duration).show()
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
            ConstLocalData.TAB_INDEX_0 -> mNavControllerWorkChild.navigate(R.id.fragmentWorkChildAll)
            ConstLocalData.TAB_INDEX_1 -> mNavControllerWorkChild.navigate(R.id.fragmentWorkChildApprove)
            ConstLocalData.TAB_INDEX_2 -> mNavControllerWorkChild.navigate(R.id.workChildReportFragment)
            ConstLocalData.TAB_INDEX_3 -> mNavControllerWorkChild.navigate(R.id.workChildClientFragment)
            ConstLocalData.TAB_INDEX_4 -> mNavControllerWorkChild.navigate(R.id.workChildAnnounceFragment)
        }

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }


}
