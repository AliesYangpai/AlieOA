package org.alieoa.work.ui.fg


import android.view.View
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import org.alieoa.basemvp.BaseFragment

import org.alieoa.work.R
import org.alieoa.work.contract.ChatMsgContract
import org.alieoa.work.contract.presenter.PresenterFgChatMsg

/**
 * 消息fragment
 */
class ChatMsgFragment : BaseFragment<ChatMsgContract.IChatMsgView, PresenterFgChatMsg>(),
    ChatMsgContract.IChatMsgView {

    @BindView(R.id.tv_common_title)
    lateinit var mTvTitle: TextView
    override fun layoutId(): Int {
        return R.layout.fragment_chat_msg
    }

    override fun initPresenter(): PresenterFgChatMsg {
        return PresenterFgChatMsg()
    }

    override fun initView(rootView: View) {
        mTvTitle.text = getString(R.string.msg)
    }

    override fun initListener() {
    }


    override fun onLazyLoad() {
    }

    override fun showToast(msg: String, duration: Int) {
        Toast.makeText(mActivity.applicationContext, msg, duration).show()
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
        //  TODO("Not yet implemented")
    }


}
