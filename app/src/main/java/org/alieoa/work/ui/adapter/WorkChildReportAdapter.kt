package org.alieoa.work.ui.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import org.alieoa.basemvp.BaseRvAdapter
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.entity.ReportBean

class WorkChildReportAdapter: BaseRvAdapter<ReportBean>() {
    override fun getLayoutId(): Int = R.layout.item_fg_work_child_report

    override fun convert(holder: BaseRvViewHolder, data: ReportBean) {
        data.let {
            holder.setText(R.id.tv_work_tip,data.typeTip)
                .setText(R.id.tv_name,data.name)
                .setText(R.id.tv_content_title,data.commonTip)
                .setText(R.id.tv_content_info,data.describe)
                .setText(R.id.tv_time,data.time)
            Glide.with(holder.itemView.context)
                .load(it.avatar)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(holder.getView(R.id.iv_user_head))
        }
    }
}