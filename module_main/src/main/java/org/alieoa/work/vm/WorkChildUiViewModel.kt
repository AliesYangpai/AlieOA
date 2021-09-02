package org.alieoa.work.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.alieoa.work.data.StateDataAllChildWrapper
import org.alieoa.work.handler.WorkChildAllListDataHandler
import org.alieoa.work.repo.AllChildRepo
import javax.inject.Inject

@HiltViewModel
class WorkChildUiViewModel @Inject constructor(val allChildRepo: AllChildRepo) :
    BaseViewModel() {


    private val _stateDataAllChildWrapperLiveData: MutableLiveData<StateDataAllChildWrapper> =
        MutableLiveData<StateDataAllChildWrapper>()

    val stateDataAllChildWrapperLiveData: LiveData<StateDataAllChildWrapper> =
        _stateDataAllChildWrapperLiveData

    private val workChildAllListDataHandler =
        WorkChildAllListDataHandler(_stateDataAllChildWrapperLiveData)

    override fun launchData(viewLifecycleOwner: LifecycleOwner) {
        getAllChild()
    }


    fun getAllChild() {
        viewModelScope.launch {
            allChildRepo.getAllChildData().let {
                workChildAllListDataHandler.onHandleData(it)
            }
        }
    }


}



