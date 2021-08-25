package org.alieoa.work

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Administrator on 2020/8/29 0029.
 * 目标：
 * 1.基本mvvm重构处理（按照https://developer.android.google.cn/jetpack/guide 完成最基本的架构构建即可）
 * 2.Jetpack重拾（使用，注意事项，原理学习）
 *   2.1 viewModel相关
 *   2.2 liveData相关
 * 3.协程
 */
@HiltAndroidApp
class AlieOaApplication:Application() {

    companion object{
        val TAG = AlieOaApplication::class.java.simpleName
    }


}