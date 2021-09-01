package org.alieoa.work.updater

import androidx.viewbinding.ViewBinding
import org.alieoa.work.data.StateDataAllChildWrapper

class WorkChildAllUpdater(var mBinding: ViewBinding) : BaseUpdater<StateDataAllChildWrapper>() {
    override fun onUpdate(stateDataWrapper: StateDataAllChildWrapper) {
        when {
            stateDataWrapper.isSuccess->{}
            else->{}
        }
    }
}