package org.alieoa.work.ui.activity

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import butterknife.BindView
import butterknife.OnClick
import org.alieoa.basemvp.BaseActivity
import org.alieoa.work.R
import org.alieoa.work.contract.WorkAddContract
import org.alieoa.work.contract.presenter.PresenterWorkAdd

class WorkAddActivity : BaseActivity<WorkAddContract.IWorkAddView, PresenterWorkAdd>(),
    WorkAddContract.IWorkAddView {


    @BindView(R.id.cl_work_add_root)
    lateinit var mClWorkAddRoot: ConstraintLayout

    @BindView(R.id.tv_go_check_in)
    lateinit var mTvGoCheckIn: TextView

    @BindView(R.id.tv_go_publish_announce)
    lateinit var mTvGoPublishAnnounce: TextView

    @BindView(R.id.tv_go_diary)
    lateinit var mTvGoDiary: TextView

    @BindView(R.id.tv_go_approval)
    lateinit var mTvGoApproval: TextView

    @OnClick(
        R.id.cl_work_add_root,
        R.id.tv_go_check_in,
        R.id.tv_go_publish_announce,
        R.id.tv_go_diary,
        R.id.tv_go_approval
    )
    fun onClick(view: View) {
        when (view.id) {
            R.id.cl_work_add_root -> finish()
            R.id.tv_go_check_in -> this.showToast("tv_go_check_in")
            R.id.tv_go_publish_announce -> this.showToast("tv_go_publish_announce")
            R.id.tv_go_diary -> this.showToast("tv_go_diary")
            R.id.tv_go_approval -> this.showToast("tv_go_approval")
        }
    }

    override fun layoutId(): Int = R.layout.activity_work_add
    override fun initPresenter(): PresenterWorkAdd = PresenterWorkAdd()

    override fun initView() {
    }

    override fun initListener() {
    }

    override fun initData() {
    }

    override fun showToast(msg: String, duration: Int) {
        Toast.makeText(this.applicationContext, msg, duration).show()
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }

}