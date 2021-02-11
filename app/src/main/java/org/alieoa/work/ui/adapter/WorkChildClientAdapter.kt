package org.alieoa.work.ui.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import org.alieoa.basemvp.BaseRvAdapter
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.entity.ClientBean

class WorkChildClientAdapter : BaseRvAdapter<ClientBean>() {


    override fun getLayoutId(): Int = R.layout.item_fg_work_child_client

    override fun convert(holder: BaseRvViewHolder, data: ClientBean) {
        data.let {
            holder.setText(R.id.tv_name,it.name)
                .setText(R.id.tv_content_title,it.name)
                .setText(R.id.tv_content_info,it.describe)
                .setText(R.id.tv_time,it.time)
            Glide.with(holder.itemView.context)
                .load(it.avatar)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(holder.getView(R.id.iv_user_head))
        }
    }
}