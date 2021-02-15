package org.alieoa.work.ui.adapter.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.entity.AllChildBean

/**
 * 审批的viewHolder
 * item_fg_work_child_approve
 */
class WorkChildApproveViewHolder(convertView: View) : BaseRvViewHolder(convertView) {
    fun setItemData(data: AllChildBean) {
        data.let {
            this.setText(R.id.tv_approver_name, it.name)
                .setText(R.id.tv_work_approve_tip, it.commonTip)
                .setText(R.id.tv_approve_title, it.tipTip.plus(it.commonTip))
                .setText(R.id.tv_approve_type, it.commonTip)
                .setText(R.id.tv_work_approve_info, it.describe)
                .setText(R.id.tv_approve_time, it.time)
                .setImageResource(R.id.iv_user_head, R.drawable.img_app_icon_go_out)
            Glide.with(this.itemView.context)
                .load(it.avatar)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(getView(R.id.iv_user_head))
        }
    }
}