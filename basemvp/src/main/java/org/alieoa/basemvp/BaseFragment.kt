package org.alieoa.basemvp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * A simple [Fragment] subclass.
 */
abstract class BaseFragment<V : IBaseContract.IBaseView, P : BasePresenter<V>> : Fragment(),
    IBaseContract.IBaseView {
    companion object {
        const val TAG = "BaseFragment"
    }

    lateinit var mActivity: AppCompatActivity
    var mPresenter: P? = null

    var mIsPrepare: Boolean = false
    var mUnbinder: Unbinder? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mActivity = context as AppCompatActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = initPresenter()
        mPresenter?.attachView(this as V)
        lifecycle.addObserver(mPresenter!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layoutId(), container, false)
        mUnbinder = ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(
            TAG,
            "===onViewCreated fg:${this.javaClass.simpleName}"
        )
        initView(view)
        initListener()
        onLazyLoad()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mUnbinder?.unbind()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) onFragmentHidden() else onFragmentResume()
        Log.d(TAG, "===onHiddenChanged fg:${this.javaClass.simpleName}   hidden:$hidden")
    }

    abstract fun layoutId(): Int
    abstract fun initPresenter(): P
    abstract fun initView(rootView: View)
    abstract fun initListener()
    abstract fun onLazyLoad()
    protected open fun onFragmentHidden() {

    }
    protected open fun onFragmentResume() {

    }
    override fun showLoadingDialog() {
        //  TODO("Not yet implemented")
    }

    override fun dismissLoadingDialog() {
        // TODO("Not yet implemented")
    }
}
