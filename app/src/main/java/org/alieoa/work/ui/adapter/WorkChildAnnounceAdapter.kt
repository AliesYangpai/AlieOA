package org.alieoa.work.ui.adapter

import com.bumptech.glide.Glide
import org.alieoa.basemvp.BaseRvAdapter
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.entity.AnnounceBean

class WorkChildAnnounceAdapter : BaseRvAdapter<AnnounceBean>() {
    override fun getLayoutId(): Int = R.layout.item_fg_work_child_announce

    override fun convert(holder: BaseRvViewHolder, data: AnnounceBean) {
        holder.setText(R.id.tv_announce_title, data.title)
            .setText(R.id.tv_announce_time, data.time)
            .setText(R.id.tv_author, data.author)
        Glide.with(holder.itemView.context).load(data.thumbnail)
            .into(holder.getView(R.id.iv_announce))
    }
}