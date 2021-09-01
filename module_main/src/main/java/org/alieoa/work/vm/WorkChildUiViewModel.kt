package org.alieoa.work.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import org.alieoa.work.data.StateDataAllChildWrapper
import org.alieoa.work.repo.AllChildRepo

class WorkChildUiViewModel @ViewModelInject constructor (val allChildRepo: AllChildRepo) : BaseViewModel() {


    val stateDataAllChildWrapper: MutableLiveData<StateDataAllChildWrapper> = MutableLiveData<StateDataAllChildWrapper>()


    override fun launchData(viewLifecycleOwner: LifecycleOwner) {
        getChildData()
    }


    fun getChildData() {
        viewModelScope.launch {
            allChildRepo.getAllChildData()
        }
    }


}



