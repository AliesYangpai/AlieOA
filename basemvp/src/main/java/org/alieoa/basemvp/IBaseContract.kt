package org.alieoa.basemvp

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