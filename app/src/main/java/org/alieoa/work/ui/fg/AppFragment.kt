package org.alieoa.work.ui.fg


import android.view.View
import android.widget.TextView
import butterknife.BindView
import org.alieoa.basemvp.BaseFragment

import org.alieoa.work.R
import org.alieoa.work.contract.AppContract
import org.alieoa.work.contract.presenter.PresenterFgApp

class AppFragment : BaseFragment<AppContract.IAppView, PresenterFgApp>(), AppContract.IAppView {

    @BindView(R.id.tv_common_title)
    lateinit var mTvCommonTitle: TextView

    override fun layoutId(): Int {
        return R.layout.fragment_app
    }

    override fun initPresenter(): PresenterFgApp {
        return PresenterFgApp()
    }

    override fun initView(rootView: View) {
        mTvCommonTitle.text = getString(R.string.app)
    }

    override fun initListener() {
    }

    override fun onLazyLoad() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }


}
