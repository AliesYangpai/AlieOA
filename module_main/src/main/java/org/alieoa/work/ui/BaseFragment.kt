package org.alieoa.work.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import org.alieoa.work.R


/**
 * 基类fragment
 * @param Binding: ViewBinding
 */
abstract class BaseFragment<Binding : ViewBinding> : Fragment() {

    private var _binding: Binding? = null
    protected val mBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = generateViewBinding(inflater, container)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUpdater()
        initObserver()
        launchData(viewLifecycleOwner)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected abstract fun generateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): Binding

    protected abstract fun initUpdater()
    protected abstract fun initObserver()
    protected abstract fun launchData(owner: LifecycleOwner)
}