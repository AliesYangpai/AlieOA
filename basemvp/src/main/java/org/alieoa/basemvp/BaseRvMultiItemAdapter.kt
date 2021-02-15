package org.alieoa.basemvp

import android.view.ViewGroup

abstract class BaseRvMultiItemAdapter<T> : BaseRvAdapter<T>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRvViewHolder =
        getViewHolderByFactory(parent, viewType)

    abstract fun getViewHolderByFactory(parent: ViewGroup, viewType: Int): BaseRvViewHolder
}