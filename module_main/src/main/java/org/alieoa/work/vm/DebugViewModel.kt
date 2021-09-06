package org.alieoa.work.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.alieoa.work.data.StateDataAllWorkSectionListWrapper
import org.alieoa.work.handler.WorkChildAllListDataHandler
import org.alieoa.work.repo.WorkSectionRepo
import javax.inject.Inject


@HiltViewModel
class DebugViewModel @Inject constructor(val workSectionRepo: WorkSectionRepo) : BaseViewModel() {


    private val _stateDataAllWorkSectionListWrapper = MutableLiveData<StateDataAllWorkSectionListWrapper>()

    val stateDataAllWorkSectionListWrapper: LiveData<StateDataAllWorkSectionListWrapper> get() = _stateDataAllWorkSectionListWrapper

    private val workChildAllListDataHandler = WorkChildAllListDataHandler(_stateDataAllWorkSectionListWrapper)

    override fun launchData(viewLifecycleOwner: LifecycleOwner) {
        getAllWorkSectionData()
    }


    fun getAllWorkSectionData() {
        viewModelScope.launch {
            workSectionRepo.getAllWorkSectionData().let {
                workChildAllListDataHandler.onHandleData(it)
            }
        }
    }
}