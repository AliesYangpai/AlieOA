package org.alieoa.basemvp

import java.lang.ref.WeakReference


/**
 * Created by Administrator on 2020/8/29 0029.
 * 类描述
 * 版本
 */
abstract class BasePresenter<V : IBaseContract.IBaseView> :
    IBaseContract.IBasePresenter {

    private var mView: V? = null
    private var mWeakReference: WeakReference<V>? = null
    fun attachView(v: V) {
        mWeakReference = WeakReference(v)
        mView = mWeakReference?.get()
    }


    private fun detachView() {
        mView = null
        mWeakReference?.clear()
        mWeakReference = null
    }


    override fun onCreate() {

    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
        mView?.dismissLoadingDialog()
    }

    override fun onDestroy() {
        mView?.dismissLoadingDialog()
        detachView()
    }


}