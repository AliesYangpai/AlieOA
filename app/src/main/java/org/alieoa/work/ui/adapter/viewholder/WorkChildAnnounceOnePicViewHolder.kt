package org.alieoa.work.ui.adapter.viewholder

import android.view.View
import com.bumptech.glide.Glide
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.entity.AllChildBean

/**
 * 公告：1图Item
 * item_fg_work_child_announce_1_pic
 */
class WorkChildAnnounceOnePicViewHolder(convertView: View) : BaseRvViewHolder(convertView) {
    fun setItemData(data: AllChildBean) {
        data.let {
            setText(R.id.tv_announce_title, it.title)
                .setText(R.id.tv_announce_time, it.time)
                .setText(R.id.tv_author, it.name)
            it.previewPicUrls?.forEach { picUrl ->
                Glide.with(itemView.context)
                    .load(picUrl)
                    .into(getView(R.id.iv_announce))
            }
        }
    }
}