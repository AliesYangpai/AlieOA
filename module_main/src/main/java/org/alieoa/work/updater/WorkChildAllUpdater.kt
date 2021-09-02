package org.alieoa.work.updater

import androidx.viewbinding.ViewBinding
import org.alieoa.work.data.StateDataAllChildWrapper

class WorkChildAllUpdater(var mBinding: ViewBinding) : BaseUpdater<StateDataAllChildWrapper>() {
    override fun onUpdate(stateDataWrapper: StateDataAllChildWrapper) {
        when(stateDataWrapper.isSuccess) {
            true->{
                println("==== name:${stateDataWrapper.list?.get(0)?.name}")
            }
            else->{
                println("==== error:${stateDataWrapper.errorMsg}")
            }
        }

    }
}