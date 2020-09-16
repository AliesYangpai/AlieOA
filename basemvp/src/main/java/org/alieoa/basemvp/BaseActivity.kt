package org.alieoa.basemvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.Unbinder

abstract class BaseActivity<V : IBaseContract.IBaseView, P : BasePresenter<V>> :
    AppCompatActivity(), IBaseContract.IBaseView {

    var mPresenter: P? = null
    var mUnbinder: Unbinder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        mUnbinder = ButterKnife.bind(this)
        mPresenter = initPresenter()
        mPresenter?.attachView(this as V)
        lifecycle.addObserver(mPresenter!!)
        initView()
        initListener()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        mUnbinder?.unbind()
    }
    abstract fun layoutId(): Int
    abstract fun initPresenter(): P
    abstract fun initView()
    abstract fun initListener()
    abstract fun initData()

    override fun showLoadingDialog() {
        //   TODO("Not yet implemented")
    }

    override fun dismissLoadingDialog() {
        //  TODO("Not yet implemented")
    }
}
