package org.alieoa.work.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.alieoa.basemvp.BaseActivity
import org.alieoa.work.R
import org.alieoa.work.contract.MainContract
import org.alieoa.work.contract.presenter.PresenterMain

class MainActivity : BaseActivity<MainContract.IMainView, PresenterMain>(),
    MainContract.IMainView,
    NavController.OnDestinationChangedListener {

    companion object {
           val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var mBottomNavigationView: BottomNavigationView
    private lateinit var mNavController: NavController
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initPresenter(): PresenterMain {
        return PresenterMain()
    }

    override fun initView() {


        mBottomNavigationView = findViewById(R.id.bnv)
        mNavController = findNavController(R.id.fg_main_container)  // 找NavController 用于控件是fragment
        /**
         * 给mBottomNavigationView设置navController 以下方法二选一：
         *  NavigationUI.setupWithNavController(mBottomNavigationView,mNavController)
         *  mBottomNavigationView.setupWithNavController(mNavController)
         */
        mBottomNavigationView.setupWithNavController(mNavController)
    }

    override fun initListener() {
        mNavController.addOnDestinationChangedListener(this)
    }

    override fun initData() {
    }

    override fun showToast(msg: String, duration: Int) {
        Toast.makeText(this.applicationContext,msg,duration).show()
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?) {
        when(destination.id) {
            R.id.chatMsgFragment -> Log.i(TAG,"chatMsgFragment")
            R.id.connectFragment -> Log.i(TAG,"connectFragment")
            R.id.workFragment -> Log.i(TAG,"workFragment")
            R.id.appFragment -> Log.i(TAG,"appFragment")
            R.id.userFragment -> Log.i(TAG,"userFragment")
        }
    }
}
