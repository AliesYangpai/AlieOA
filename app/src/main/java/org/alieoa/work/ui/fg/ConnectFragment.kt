package org.alieoa.work.ui.fg


import android.icu.text.CaseMap
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R

import org.alieoa.work.contract.ConnectContract
import org.alieoa.work.contract.presenter.PresenterFgConnect


class ConnectFragment : BaseFragment<ConnectContract.IConnectView, PresenterFgConnect>(),
    ConnectContract.IConnectView {

    @BindView(R.id.tv_common_title)
    lateinit var mTvCommonTitle: TextView

    @BindView(R.id.iv_right)
    lateinit var mIvRight: ImageView

    override fun layoutId(): Int {
        return R.layout.fragment_connect
    }

    override fun initPresenter(): PresenterFgConnect {
        return PresenterFgConnect()
    }

    override fun initView(rootView: View) {
        mTvCommonTitle.text = getString(R.string.connect)
        mIvRight.setImageResource(R.drawable.img_add_friends)
    }

    override fun initListener() {
    }


    override fun onLazyLoad() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }

//R.layout.fragment_connect

}
