package org.alieoa.work.ui.fg


import android.view.View
import org.alieoa.basemvp.BaseFragment

import org.alieoa.work.R
import org.alieoa.work.contract.ChatMsgContract
import org.alieoa.work.contract.presenter.PresenterFgChatMsg

/**
 * 消息fragment
 */
class ChatMsgFragment : BaseFragment<ChatMsgContract.IChatMsgView, PresenterFgChatMsg>(),
    ChatMsgContract.IChatMsgView {


    override fun layoutId(): Int {
        return R.layout.fragment_chat_msg
    }

    override fun initPresenter(): PresenterFgChatMsg {
        return PresenterFgChatMsg()
    }

    override fun initView(rootView: View) {

    }

    override fun initListener() {
    }


    override fun onLazyLoad() {
    }

    override fun onDataBackFail(code: Int, errorMsg: String) {
      //  TODO("Not yet implemented")
    }


}
