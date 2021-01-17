package org.alieoa.work.method

import org.alieoa.work.callback.OnDataBackListener
import org.alieoa.work.entity.FrequentContact
import org.alieoa.work.universal.db.entity.User

interface IUser {
    fun getUserInfo(onDataBackListener: OnDataBackListener<User>)

    /**
     * mainly to practice lambda
     */
    fun getUserInfo(
        onStart: () -> Unit,
        onSuccess: (User) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    )

    /**
     * 获取常用联系人
     */
    fun getFrequentContacts(
        onStart: () -> Unit,
        onSuccess: (ArrayList<FrequentContact>) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    )
}