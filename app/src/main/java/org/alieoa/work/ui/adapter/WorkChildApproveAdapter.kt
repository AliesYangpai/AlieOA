package org.alieoa.work.ui.adapter

import org.alieoa.basemvp.BaseRvAdapter
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.entity.ApproveBean

class WorkChildApproveAdapter : BaseRvAdapter<ApproveBean>() {
    override fun getLayoutId(): Int = R.layout.item_fg_work_child_approve

    override fun convert(holder: BaseRvViewHolder, data: ApproveBean) {
        data.let {
            holder.setText(R.id.tv_content, it.approveName)
                .setImageResource(R.id.iv, R.drawable.img_app_icon_go_out)
        }
    }
}