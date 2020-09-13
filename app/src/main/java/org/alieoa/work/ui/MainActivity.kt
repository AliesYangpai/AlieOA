package org.alieoa.work.ui

import android.view.MenuItem
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.alieoa.basemvp.BaseActivity
import org.alieoa.work.R
import org.alieoa.work.contract.MainContract
import org.alieoa.work.contract.presenter.PresenterMain

class MainActivity : BaseActivity<MainContract.IMainView, PresenterMain>(), MainContract.IMainView {

    lateinit var mBottomNavigationView: BottomNavigationView
    lateinit var mNavController: NavController
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter(): PresenterMain {
        return PresenterMain()
    }

    override fun initView() {

        // 初级做法：

        /**
         * 关于navGraph所在控件的说明，这里有点小坑，需要注意
         * 如果是<fragment>标签对于NavController 获取如下
         *  因为标签是<fragment> 所以不必使用supportFragmentManager
         *  直接获取到到 mNavController 参考方法：
         *   Fragment.findNavController()
         *   View.findNavController()
         *   Activity.findNavController(viewId: Int)
         *
         */

        mBottomNavigationView = findViewById(R.id.bnv)
        mNavController = findNavController(R.id.fg_main_container)  // 找NavController 用于控件是fragment
        /**
         * 关于navGraph所在控件的说明，这里有点小坑，需要注意
         * 如果是<FragmentContainerView>标签对于NavController 获取如下
         * 使用 supportFragmentManager 先找到NavHostFragment，用NavHostFragment去获取findNavController
         */
//        mBottomNavigationView = findViewById(R.id.bnv)
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fg_main_container) as NavHostFragment // 找NavController 用于控件是FragmentContainerView
//        mNavController = navHostFragment.findNavController()

    }

    override fun initListener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener { p0 ->
            when (p0.itemId) {
                R.id.chatMsgFragment ->
                    mNavController.navigate(p0.itemId)
                R.id.connectFragment ->
                    mNavController.navigate(p0.itemId)
                R.id.workFragment ->
                    mNavController.navigate(p0.itemId)
                R.id.appFragment ->
                    mNavController.navigate(p0.itemId)
                R.id.userFragment ->
                    mNavController.navigate(p0.itemId)
            }
            true
        }
    }

    override fun initData() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }
}
