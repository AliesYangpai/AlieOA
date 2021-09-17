package org.alieoa.work.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import org.alieoa.work.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private val mTestUserViewModel by viewModels<TestUserViewModel>()
    private lateinit var mBinding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTestBinding.inflate(layoutInflater)
        init()
    }

    private fun init() {
        mTestUserViewModel.mUserData.observe(this, Observer {
            mBinding.mTv1.text = it.mName + it.mAge
        })

        var count: Short = 0;
        mBinding.mBtn1.setOnClickListener {
            mTestUserViewModel.loadUserData(++count)
            startActivity(Intent(this, Test2Activity::class.java))
        }
    }
}