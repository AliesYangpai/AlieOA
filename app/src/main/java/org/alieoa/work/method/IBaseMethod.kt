package org.alieoa.work.method

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

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