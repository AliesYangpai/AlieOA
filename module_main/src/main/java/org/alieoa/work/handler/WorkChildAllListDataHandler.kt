package org.alieoa.work.handler

import androidx.lifecycle.MutableLiveData
import org.alieoa.work.data.StateDataAllChildWrapper
import org.alieoa.work.entity.AllChildBean

class WorkChildAllListDataHandler(private val stateDataWrapperLiveData: MutableLiveData<StateDataAllChildWrapper>) :
    BaseDataHandler<List<AllChildBean>>() {
    override fun onHandleDataSuccess(ret: Boolean, data: List<AllChildBean>?) {
        StateDataAllChildWrapper().also {
            it.isSuccess = ret
            it.list = data
            it.isVisible = true
            stateDataWrapperLiveData.value = it
        }
    }

    override fun onHandleDataError(ret: Boolean, msg: String?) {
        StateDataAllChildWrapper().also {
            it.isSuccess = ret
            it.list = null
            it.isVisible = false
            stateDataWrapperLiveData.value = it
        }
    }

}