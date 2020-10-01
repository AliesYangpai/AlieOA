package org.alieoa.work.callback

interface OnDataBackListener<T> {
    fun onStar()
    fun onBeforeFinish() // 在出结果之前(比如onComplete或者error之前)回调
    fun onSuccess(t: T)
    fun onError(code: Int, msg: String)
    fun onFinish()
}