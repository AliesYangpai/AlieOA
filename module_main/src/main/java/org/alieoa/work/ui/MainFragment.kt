package org.alieoa.work.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import dagger.hilt.android.AndroidEntryPoint
import org.alieoa.work.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun generateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding  = FragmentMainBinding.inflate(inflater,container,false)

    override fun initUpdater() {
   //     TODO("Not yet implemented")
    }

    override fun initObserver() {
     //   TODO("Not yet implemented")
    }

    override fun launchData(owner: LifecycleOwner) {
       // TODO("Not yet implemented")
    }

}