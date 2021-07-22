package org.alieoa.work

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.alieoa.work.databinding.ActivityMainBinding
import org.alieoa.work.test.TestActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        showTest()
    }

    private fun showTest() {
        startActivity(Intent(this, TestActivity::class.java))
    }
}