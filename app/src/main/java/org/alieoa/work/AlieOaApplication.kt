package org.alieoa.work

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述
 * 版本
 * //kotlinx.android.synthetic.main.布局名称.*
 */
class AlieOaApplication:Application(),Application.ActivityLifecycleCallbacks {


    companion object{
        val TAG = AlieOaApplication::class.java.simpleName
        @Volatile
        private var mInstance:AlieOaApplication? = null
        fun getInstance():AlieOaApplication = mInstance?: synchronized(this) {
            mInstance?:AlieOaApplication().also {
                mInstance = it
            }
        }
    }
    override fun onCreate() {
        super.onCreate()
        mInstance = this
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