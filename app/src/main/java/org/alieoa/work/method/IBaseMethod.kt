package org.alieoa.work.method

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * 这个基础类来进行rxjava回收处理
 */
abstract class IBaseMethod {
    private val mDisposable by lazy {
        CompositeDisposable()
    }

    fun addDisposable(disposable: Disposable) {
        mDisposable.add(disposable)
    }

    fun clearAllDisposable() {
        mDisposable.clear()
    }
}