package org.alieoa.work.ui

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.alieoa.basemvp.BaseActivity
import org.alieoa.work.R
import org.alieoa.work.contract.MainContract
import org.alieoa.work.contract.presenter.PresenterMain

class MainActivity : BaseActivity<MainContract.IMainView,PresenterMain>(),MainContract.IMainView {

    lateinit var mBottomNavigationView: BottomNavigationView
    lateinit var mNavController: NavController
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter(): PresenterMain {
       return PresenterMain()
    }

    override fun initView() {
        mBottomNavigationView = findViewById(R.id.bnv)
        mNavController = findNavController(R.id.fg_main_container)  // 找NavController
        NavigationUI.setupWithNavController(mBottomNavigationView,mNavController)
    }

    override fun initListener() {
    }

    override fun initData() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }
}
