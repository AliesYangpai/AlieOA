package org.alieoa.work.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

abstract class BaseViewModel:ViewModel(){

    abstract fun launchData(viewLifecycleOwner: LifecycleOwner)
}