package org.alieoa.work.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestUserViewModel:ViewModel() {

    /**
     * ===============Data==============
     */
    val mUserData:MutableLiveData<TestUserData> by lazy { MutableLiveData<TestUserData>().also { mRepoUser.loadTestUserInfo() } }


    /**
     * ===============Repo==============
     */

    private val mRepoUser:TestRepoUser by lazy { TestRepoUser() }

    fun loadUserData(short: Short) {
        mUserData.value =  mRepoUser.loadTestUserInfo(short)
    }

}