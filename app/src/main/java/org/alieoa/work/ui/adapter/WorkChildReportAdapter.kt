package org.alieoa.work.ui.adapter

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
                .setText(R.id.tv_work_content_info,data.describe)
                .setText(R.id.tv_time,data.time)
                .setImageResource(R.id.iv_user_head,R.drawable.img_share_to)
        }
    }
}