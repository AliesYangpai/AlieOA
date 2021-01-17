package org.alieoa.work.callback

interface OnDataBackListener<T> {
    fun onStar()
    fun onSuccess(t: T)
    fun onError(code: Int, msg: String)
    fun onFinish()
}