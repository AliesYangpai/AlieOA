package org.alieoa.work.ui.adapter.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.entity.AllChildBean

/**
 * 客户相关的viewHolder
 * item_fg_work_child_client
 */
class WorkChildClientViewHolder(convertView: View) : BaseRvViewHolder(convertView) {
    fun setItemData(data: AllChildBean) {
        data.let {
            this.setText(R.id.tv_name,it.name)
                .setText(R.id.tv_content_title,it.name)
                .setText(R.id.tv_content_info,it.describe)
                .setText(R.id.tv_time,it.time)
            Glide.with(this.itemView.context)
                .load(it.avatar)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(this.getView(R.id.iv_user_head))
        }
    }
}