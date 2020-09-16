package org.alieoa.work.ui.fg


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import butterknife.BindView
import butterknife.OnClick
import com.google.android.material.tabs.TabLayout
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.AlieOaApplication
import org.alieoa.work.R

import org.alieoa.work.contract.WorkContract
import org.alieoa.work.contract.presenter.PresenterFgWork

class WorkFragment : BaseFragment<WorkContract.IWorkView, PresenterFgWork>(),
    WorkContract.IWorkView {

    @BindView(R.id.tv_left)
    lateinit var mTvLeft:TextView

    @BindView(R.id.iv_right)
    lateinit var mIvRight:ImageView

    @BindView(R.id.tbl_work_child)
    lateinit var mTblWorkChild:TabLayout

    @BindView(R.id.fg_work_child_container)
    lateinit var mFgWorkChildContainer:Fragment

    @BindView(R.id.iv_add)
    lateinit var mIvAdd:ImageView

    @OnClick(R.id.iv_right,
        R.id.iv_add)
    fun onClick(view:View) {
        when (view.id){
            R.id.iv_right->
                Toast.makeText(mActivity.applicationContext,"iv_right",Toast.LENGTH_SHORT).show()
            R.id.iv_add ->
                Toast.makeText(mActivity.applicationContext,"iv_add",Toast.LENGTH_SHORT).show()
        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_work
    }

    override fun initPresenter(): PresenterFgWork {
        return PresenterFgWork()
    }

    override fun initView(rootView: View) {
        val navController = findNavController()

    }

    override fun initListener() {
    }

    override fun onLazyLoad() {

    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }


}
