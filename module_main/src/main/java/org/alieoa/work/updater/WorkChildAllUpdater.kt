package org.alieoa.work.updater

import androidx.viewbinding.ViewBinding
import org.alieoa.work.data.StateDataAllWorkSectionListWrapper

class WorkChildAllUpdater(var mBinding: ViewBinding) : BaseUpdater<StateDataAllWorkSectionListWrapper>() {
    override fun onUpdate(stateDataListWrapperWork: StateDataAllWorkSectionListWrapper) {
        when(stateDataListWrapperWork.isSuccess) {
            true->{
                println("$tag describe:${stateDataListWrapperWork.mList?.get(0)?.describe}")
            }
            else->{
                println("$tag error:${stateDataListWrapperWork.errorMsg}")
            }
        }

    }
}