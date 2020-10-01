package org.alieoa.basemvp

import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


/**
 * Created by Administrator on 2020/8/30 0030.
 * 类描述
 * 版本
 */
interface IBaseContract {
    interface IBaseView {
        fun showLoadingDialog()
        fun dismissLoadingDialog()
        fun showToast(msg:String,duration:Int = Toast.LENGTH_SHORT)
        fun onDataBackFail(code: Int, errorMsg: String)
    }

    interface IBaseModel {}
    interface IBasePresenter : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate()

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onStart()

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onResume()

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onPause()

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onStop()

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onDestroy()

    }
}