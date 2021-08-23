package org.alieoa.work.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_test.*
import org.alieoa.work.R

class TestActivity : AppCompatActivity() {

    private val mTestUserViewModel by viewModels<TestUserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        init()
    }

    private fun init(){
        mTestUserViewModel.mUserData.observe(this, Observer {
            mTv1.text = it.mName + it.mAge
        })

        var count:Short= 0;
        mBtn1.setOnClickListener {
            mTestUserViewModel.loadUserData(++count)
            startActivity(Intent(this,Test2Activity::class.java))
        }
    }
}