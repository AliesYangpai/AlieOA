package org.alieoa.work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.alieoa.work.databinding.ActivityMainBinding
import org.alieoa.work.updater.WorkChildAllUpdater
import org.alieoa.work.vm.DebugViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private val debugViewModel by viewModels<DebugViewModel>()
    private lateinit var workChildAllUpdater: WorkChildAllUpdater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        showTest()
    }

    private fun showTest() {
//        startActivity(Intent(this, TestActivity::class.java))
        workChildAllUpdater = WorkChildAllUpdater(mBinding)
        debugViewModel.stateDataAllWorkSectionListWrapper.observe(this,workChildAllUpdater::onUpdate)
        debugViewModel.launchData(this)
    }



}