package org.alieoa.work.ui


import org.alieoa.basemvp.BaseActivity
import org.alieoa.work.R
import org.alieoa.work.contract.MainContract
import org.alieoa.work.contract.presenter.PresenterMain

class MainActivity : BaseActivity<MainContract.IMainView,PresenterMain>(),MainContract.IMainView {


    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter(): PresenterMain {
       return PresenterMain()
    }

    override fun initView() {
    }

    override fun initListener() {
    }

    override fun initData() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }
}
