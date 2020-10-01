package org.alieoa.basemvp

import android.content.Context
import android.os.Bundle
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
abstract class BaseFragment<V : IBaseContract.IBaseView, P : BasePresenter<V>> : Fragment() ,IBaseContract.IBaseView{
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
        lifecycle.addObserver(mPresenter!!)
//        mPresenter?.attachView(this as V)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view = inflater.inflate(layoutId(), container, false)
        mUnbinder =  ButterKnife.bind(this,view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initListener()
        onLazyLoad()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mUnbinder?.unbind()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && mIsPrepare) {
            onLazyLoad()
        }
    }

    abstract fun layoutId(): Int
    abstract fun initPresenter(): P
    abstract fun initView(rootView:View)
    abstract fun initListener()
    abstract fun onLazyLoad()

    override fun showLoadingDialog() {
        //  TODO("Not yet implemented")
    }

    override fun dismissLoadingDialog() {
        // TODO("Not yet implemented")
    }
}
