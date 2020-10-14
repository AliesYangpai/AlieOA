package org.alieoa.work.ui.fg


import android.view.View
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R

import org.alieoa.work.contract.ConnectContract
import org.alieoa.work.contract.presenter.PresenterFgConnect
import org.alieoa.work.test.TestValue
import org.alieoa.work.ui.adapter.TopContactAdapter


class ConnectFragment : BaseFragment<ConnectContract.IConnectView, PresenterFgConnect>(),
    ConnectContract.IConnectView {

    @BindView(R.id.tv_common_title)
    lateinit var mTvCommonTitle: TextView

    @BindView(R.id.iv_right)
    lateinit var mIvRight: ImageView

    @BindView(R.id.lv_top_contact)
    lateinit var mLvTopContact: ListView

    var mTopContactAdapter: TopContactAdapter? = null

    @OnClick(
        R.id.iv_phone_contact,
        R.id.tv_phone_contact,
        R.id.iv_my_friends,
        R.id.tv_my_friends,
        R.id.iv_my_groups,
        R.id.tv_my_groups,
        R.id.iv_department_structure,
        R.id.tv_department_structure,
    )
    fun onClick(view: View) {
        when (view.id) {
            R.id.iv_phone_contact, R.id.tv_phone_contact -> {
                Toast.makeText(mActivity.applicationContext, "联系人", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_my_friends, R.id.tv_my_friends -> {
                Toast.makeText(mActivity.applicationContext, "我的好友", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_my_groups, R.id.tv_my_groups -> {
                Toast.makeText(mActivity.applicationContext, "我的群组", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_department_structure, R.id.tv_department_structure -> {
                Toast.makeText(mActivity.applicationContext, "部门架构", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_connect
    }

    override fun initPresenter(): PresenterFgConnect {
        return PresenterFgConnect()
    }

    override fun initView(rootView: View) {
        mTvCommonTitle.text = getString(R.string.connect)
        mIvRight.setImageResource(R.drawable.img_add_friends)
        mTopContactAdapter = TopContactAdapter(mActivity)
        mLvTopContact.adapter = mTopContactAdapter
    }

    override fun initListener() {
    }


    override fun onLazyLoad() {
        mTopContactAdapter?.setData(TestValue.getTestContacts())
    }

    override fun showToast(msg: String, duration: Int) {
        Toast.makeText(mActivity.applicationContext, msg, duration).show()
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }

//R.layout.fragment_connect

}
