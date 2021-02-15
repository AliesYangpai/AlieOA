package org.alieoa.work.ui.adapter

import android.view.ViewGroup
import org.alieoa.basemvp.BaseRvMultiItemAdapter
import org.alieoa.basemvp.BaseRvViewHolder
import org.alieoa.work.entity.AllChildBean
import org.alieoa.work.manager.ViewHolderMgr
import org.alieoa.work.ui.adapter.viewholder.*

class WorkChildAllAdapter : BaseRvMultiItemAdapter<AllChildBean>() {

    override fun getLayoutId(): Int = 0;

    override fun getViewHolderByFactory(parent: ViewGroup, viewType: Int): BaseRvViewHolder =
        ViewHolderMgr.getInstance().getViewHolder(parent, viewType)

    override fun convert(holder: BaseRvViewHolder, data: AllChildBean) {
        when (holder) {
            is WorkChildApproveViewHolder -> {
                holder.setItemData(data)
            }
            is WorkChildClientViewHolder -> {
                holder.setItemData(data)
            }
            is WorkChildAnnounceNoPicViewHolder -> {
                holder.setItemData(data)
            }
            is WorkChildAnnounceOnePicViewHolder -> {
                holder.setItemData(data)
            }
            is WorkChildAnnounceThreePicViewHolder -> {
                holder.setItemData(data)
            }
        }
    }

}