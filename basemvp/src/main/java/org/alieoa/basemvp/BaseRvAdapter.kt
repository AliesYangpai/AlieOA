package org.alieoa.basemvp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRvAdapter<T> : RecyclerView.Adapter<BaseRvViewHolder>() {


    private var onItemClick: ((T, Int) -> Unit)? = null

    var onItemClickClick: ((T, Int, Int) -> Unit)? = null


    var mData: ArrayList<T>? = null
        set(value) {
            field.let {
                when (it) {
                    null -> field = value
                    else -> {
                        field!!.clear()
                        field!!.addAll(value!!)
                    }
                }
            }
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRvViewHolder =
        BaseRvViewHolder(
            LayoutInflater.from(parent.context).inflate(getLayoutId(), parent, false))

    override fun onBindViewHolder(holder: BaseRvViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(mData!![position], position)
        }
        convert(holder, mData!![position])
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int = when (mData) {
        null -> 0
        else -> mData!!.size
    }

    abstract fun getLayoutId(): Int

    abstract fun convert(holder: BaseRvViewHolder, data: T)


    /**
     * item点击事件
     */
    fun setOnItemClick(block: ((T, Int) -> Unit)?) {
        onItemClick = block
    }

    /**
     * 子控件点击事件
     */
    fun setOnItemChildClick(block: ((T, Int, Int) -> Unit)?) {
        onItemClickClick = block
    }


}