package org.alieoa.work

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by Administrator on 2020/8/29 0029.
 * 目标：
 * 1.基本mvvm重构处理（按照https://developer.android.google.cn/jetpack/guide 完成最基本的架构构建即可）
 * 2.Jetpack重拾（使用，注意事项，原理学习）
 *   2.1 viewModel相关
 *   2.2 liveData相关
 * 3.协程
 */
class AlieOaApplication:Application(),Application.ActivityLifecycleCallbacks {

    companion object{
        val TAG = AlieOaApplication::class.java.simpleName
    }
    override fun onCreate() {
        super.onCreate()
    }

    override fun onActivityPaused(activity: Activity) {
//        TODO("Not yet implemented")
    }

    override fun onActivityStarted(activity: Activity) {
//        TODO("Not yet implemented")
    }

    override fun onActivityDestroyed(activity: Activity) {
//        TODO("Not yet implemented")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
//        TODO("Not yet implemented")
    }

    override fun onActivityStopped(activity: Activity) {
//        TODO("Not yet implemented")
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
//        TODO("Not yet implemented")
    }

    override fun onActivityResumed(activity: Activity) {
//        TODO("Not yet implemented")
    }

}