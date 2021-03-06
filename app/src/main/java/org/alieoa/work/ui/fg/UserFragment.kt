package org.alieoa.work.ui.fg


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.alieoa.basemvp.BaseFragment

import org.alieoa.work.R
import org.alieoa.work.constant.ConstLocalData
import org.alieoa.work.contract.UserContract
import org.alieoa.work.contract.presenter.PresenterFgUser
import org.alieoa.work.universal.db.entity.User

class UserFragment : BaseFragment<UserContract.IUserView, PresenterFgUser>(),
    UserContract.IUserView {


    @BindView(R.id.tv_common_title)
    lateinit var mTvCommonTitle: TextView

    @BindView(R.id.iv_user_head)
    lateinit var mIvUserHead: ImageView

    @BindView(R.id.tv_name)
    lateinit var mTvName: TextView

    @BindView(R.id.tv_enterprise_name)
    lateinit var mTvEnterpriseName: TextView

    @OnClick(
        R.id.iv_wallet,
        R.id.tv_wallet,
        R.id.iv_file,
        R.id.tv_file,
        R.id.iv_organization_info,
        R.id.tv_organization_info,
        R.id.iv_help_center,
        R.id.tv_help_center,
        R.id.iv_share_to_friend,
        R.id.tv_share_to_friend,
        R.id.iv_setting,
        R.id.tv_setting
    )
    fun onClick(view: View) {
        when (view.id) {
            R.id.iv_wallet, R.id.tv_wallet -> {
                Toast.makeText(mActivity.applicationContext, "钱包", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_file, R.id.tv_file -> {
                Toast.makeText(mActivity.applicationContext, "文件", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_organization_info, R.id.tv_organization_info -> {
                Toast.makeText(mActivity.applicationContext, "组织信息", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_help_center, R.id.tv_help_center -> {
                Toast.makeText(mActivity.applicationContext, "帮助中心", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_share_to_friend, R.id.tv_share_to_friend -> {
                Toast.makeText(mActivity.applicationContext, "分享给朋友", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_setting, R.id.tv_setting -> {
                Toast.makeText(mActivity.applicationContext, "设置", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_user
    }

    override fun initPresenter(): PresenterFgUser {
        return PresenterFgUser()
    }

    override fun initView(rootView: View) {
        mTvCommonTitle.text = getString(R.string.mine)
    }

    override fun initListener() {
    }

    override fun onLazyLoad() {
        println("=========UserFragment === onLazyLoad")
        mPresenter?.doGetUserInfoByLambda()
    }

    override fun setDataOnUserInfo(user: User?) {
        mTvName.text = user?.fullName
        mTvEnterpriseName.text = user?.company
        Glide.with(mActivity).load(user?.avatar)
            .placeholder(R.drawable.test_img_head_round)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(mIvUserHead)
    }

    override fun showToast(msg: String, duration: Int) {
        Toast.makeText(mActivity.applicationContext, msg, duration).show()
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }

}
