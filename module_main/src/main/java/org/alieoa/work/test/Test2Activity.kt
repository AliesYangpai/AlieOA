package org.alieoa.work.test

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.alieoa.work.R
import kotlinx.coroutines.*
import org.alieoa.work.databinding.ActivityTest2Binding

/**
 * GlobalScope:Process级别,activity/fragment销毁了也存在
 * MainScope：在activity中使用，可以在onDestroy中取消协程
 * viewModelScope：只能在viewModel中使用，绑定viewModel声明周期
 * lifecycleScope：只能在activity、fragment中使用，绑定activity、fragment的生命周期
 */
class Test2Activity : AppCompatActivity() {
    lateinit var mBinding: ActivityTest2Binding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =   ActivityTest2Binding.inflate(layoutInflater)
        mBinding.mBtn1.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) {
                    println("thread:开始执行  ${Thread.currentThread().name}")
                    getUserData()
                }.let {
                    println("thread:执行完成${Thread.currentThread().name}")
                    mBinding.mTv1.text = it.mName + it.mAge
                }
            }
        }
    }


    private suspend fun getUserData(): TestUserData {
        println("thread:getUserData（）  ${Thread.currentThread().name}")
        delay(5000)
        return TestUserData("南瓜", 15)
    }
}