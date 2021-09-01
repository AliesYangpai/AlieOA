package org.alieoa.work

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.alieoa.work.databinding.ActivityMainBinding
import org.alieoa.work.test.TestActivity
import org.alieoa.work.updater.WorkChildAllUpdater
import org.alieoa.work.vm.WorkChildUiViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private val workChildUiViewModel by viewModels<WorkChildUiViewModel>()
    private lateinit var workChildAllUpdater: WorkChildAllUpdater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        showTest()
    }

    private fun showTest() {
        startActivity(Intent(this, TestActivity::class.java))

        workChildAllUpdater = WorkChildAllUpdater(mBinding)
        workChildUiViewModel.stateDataAllChildWrapper.observe(this,workChildAllUpdater::onUpdate)
    }


}