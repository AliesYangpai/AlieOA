package org.alieoa.work.manager

import android.view.LayoutInflater
import android.view.ViewGroup
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.R
import org.alieoa.work.constant.ConstViewHolderData
import org.alieoa.work.ui.adapter.viewholder.*


class ViewHolderMgr {

    companion object {
        @Volatile
        private var mInstance: ViewHolderMgr? = null
        fun getInstance(): ViewHolderMgr = mInstance ?: synchronized(this) {
            mInstance ?: ViewHolderMgr().also {
                mInstance = it
            }
        }
    }

    /**
     * 根据type获取对应的viewHolder
     */
    fun <T : BaseRvViewHolder> getViewHolder(viewGroup: ViewGroup, type: Int): T {

        return when (type) {
            ConstViewHolderData.WorkChildAll.ITEM_TYPE_APPROVE ->
                WorkChildApproveViewHolder(
                    LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.item_fg_work_child_approve, null)
                ) as T
            ConstViewHolderData.WorkChildAll.ITEM_TYPE_CLIENT ->
                WorkChildClientViewHolder(
                    LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.item_fg_work_child_client, null)
                ) as T
            ConstViewHolderData.WorkChildAll.ITEM_TYPE_ANNOUNCE_0 ->
                WorkChildAnnounceNoPicViewHolder(
                    LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.item_fg_work_child_announce_0_pic, null)
                ) as T
            ConstViewHolderData.WorkChildAll.ITEM_TYPE_ANNOUNCE_1 ->
                WorkChildAnnounceOnePicViewHolder(
                    LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.item_fg_work_child_announce_1_pic, null)
                ) as T
            ConstViewHolderData.WorkChildAll.ITEM_TYPE_ANNOUNCE_3 ->
                WorkChildAnnounceThreePicViewHolder(
                    LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.item_fg_work_child_announce_3_pic, null)
                ) as T
            else -> BaseRvViewHolder(
                LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_fg_work_child_approve, null)
            ) as T
        }
    }

}