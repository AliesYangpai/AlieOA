package org.alieoa.work.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import dagger.hilt.android.AndroidEntryPoint
import org.alieoa.work.databinding.FragmentTestBinding


@AndroidEntryPoint
class TestFragment : BaseFragment<FragmentTestBinding>() {
    override fun generateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTestBinding = FragmentTestBinding.inflate(inflater,container,false)
    override fun initUpdater() {
     //   TODO("Not yet implemented")
    }

    override fun initObserver() {
       // TODO("Not yet implemented")
    }

    override fun launchData(owner: LifecycleOwner) {
       // TODO("Not yet implemented")
    }
}