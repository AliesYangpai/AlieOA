package org.alieoa.work.method

import org.alieoa.work.callback.OnDataBackListener
import org.alieoa.work.db.entity.User

interface IUser {
    fun getUserInfo(onDataBackListener: OnDataBackListener<User>)
}