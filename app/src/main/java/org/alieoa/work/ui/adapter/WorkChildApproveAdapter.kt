package org.alieoa.work.ui.adapter

import com.bumptech.glide.Glide
import org.alieoa.basemvp.BaseRvAdapter
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.entity.ApproveBean

class WorkChildApproveAdapter : BaseRvAdapter<ApproveBean>() {


    override fun getLayoutId(): Int = R.layout.item_fg_work_child_approve

    override fun convert(holder: BaseRvViewHolder, data: ApproveBean) {
        data.let {
            holder.setText(R.id.tv_approver_name, it.approveName)
                .setText(R.id.tv_work_approve_tip, it.approveCommonTip)
                .setText(R.id.tv_approve_title, it.approveTypeTip.plus(it.approveCommonTip))
                .setText(R.id.tv_approve_type, it.approveCommonTip)
                .setText(R.id.tv_work_approve_info, it.describe)
                .setText(R.id.tv_approve_time, it.time)
                .setImageResource(R.id.iv_user_head, R.drawable.img_app_icon_go_out)
            Glide.with(holder.itemView.context)
                .load(it.approveAvatar)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.getView(R.id.iv_user_head))
        }
    }



}