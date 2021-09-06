package org.alieoa.work.handler

import androidx.lifecycle.MutableLiveData
import org.alieoa.work.data.StateDataAllWorkSectionListWrapper
import org.alieoa.work.entity.WorkSectionAll

class WorkChildAllListDataHandler(private val stateDataWrapperLiveDataWork: MutableLiveData<StateDataAllWorkSectionListWrapper>) :
    BaseDataHandler<List<WorkSectionAll>>() {
    override fun onHandleDataSuccess(ret: Boolean, data: List<WorkSectionAll>?) {
        StateDataAllWorkSectionListWrapper().also {
            it.isSuccess = ret
            it.mList = data
            it.isVisible = true
            stateDataWrapperLiveDataWork.value = it
        }
    }

    override fun onHandleDataError(ret: Boolean, msg: String?) {
        StateDataAllWorkSectionListWrapper().also {
            it.isSuccess = ret
            it.errorMsg = msg
            stateDataWrapperLiveDataWork.value = it
        }
    }

}