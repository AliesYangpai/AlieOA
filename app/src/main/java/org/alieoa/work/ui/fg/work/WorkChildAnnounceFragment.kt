package org.alieoa.work.ui.fg.work

import androidx.fragment.app.Fragment
import android.view.View
import org.alieoa.basemvp.BaseFragment
import org.alieoa.work.R
import org.alieoa.work.contract.WorkChildAnnounceContract
import org.alieoa.work.contract.presenter.PresenterFgWorkChildAnnounce

/**
 * A simple [Fragment] subclass.
 * Use the [WorkChildAnnounceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkChildAnnounceFragment :
    BaseFragment<WorkChildAnnounceContract.IWorkChildAnnounceView, PresenterFgWorkChildAnnounce>(),
    WorkChildAnnounceContract.IWorkChildAnnounceView {
    override fun layoutId(): Int = R.layout.fragment_work_child_announce
    override fun initPresenter(): PresenterFgWorkChildAnnounce = PresenterFgWorkChildAnnounce()

    override fun initView(rootView: View) {
      //  TODO("Not yet implemented")
    }

    override fun initListener() {
      //  TODO("Not yet implemented")
    }

    override fun onLazyLoad() {
       // TODO("Not yet implemented")
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
      //  TODO("Not yet implemented")
    }

}