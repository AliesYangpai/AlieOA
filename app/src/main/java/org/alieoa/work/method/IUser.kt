package org.alieoa.work.method

import org.alieoa.work.callback.OnDataBackListener
import org.alieoa.work.universal.db.entity.User

interface IUser {
    fun getUserInfo(onDataBackListener: OnDataBackListener<User>)

    /**
     * mainly to practice lambda
     */
    fun getUserInfo(
        onStart: () -> Unit,
        onBeforeFinish: () -> Unit,
        onSuccess: (User) -> Unit,
        onError: (Int, String) -> Unit,
        onFinish: () -> Unit
    )
}