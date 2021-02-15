package org.alieoa.basemvp

import android.view.ViewGroup

/**
 * 多Item的viewHolder工厂接口
 */
interface IViewHolderFactory<T : BaseRvViewHolder> {
    fun getItemHolder(parent: ViewGroup, type: Int): T
}