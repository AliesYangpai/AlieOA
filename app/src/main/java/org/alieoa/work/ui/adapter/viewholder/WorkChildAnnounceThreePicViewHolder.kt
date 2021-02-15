package org.alieoa.work.ui.adapter.viewholder

import android.view.View
import com.bumptech.glide.Glide
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.constant.ConstLocalData
import org.alieoa.work.entity.AllChildBean

/**
 * 公告：3图item
 * item_fg_work_child_announce_3_pic
 */
class WorkChildAnnounceThreePicViewHolder(convertView: View) : BaseRvViewHolder(convertView) {

    fun setItemData(data: AllChildBean) {
        data.let {
            setText(R.id.tv_announce_title, data.title)
                .setText(R.id.tv_announce_time, data.time)
                .setText(R.id.tv_author, data.name)
            if (data.previewPicUrls?.size == ConstLocalData.COUNT_3) {
                Glide.with(itemView.context)
                    .load(data.previewPicUrls?.get(ConstLocalData.LIST_INDEX_0))
                    .into(getView(R.id.iv_announce1))
                Glide.with(itemView.context)
                    .load(data.previewPicUrls?.get(ConstLocalData.LIST_INDEX_1))
                    .into(getView(R.id.iv_announce2))
                Glide.with(itemView.context)
                    .load(data.previewPicUrls?.get(ConstLocalData.LIST_INDEX_2))
                    .into(getView(R.id.iv_announce3))
            }
        }

    }
}