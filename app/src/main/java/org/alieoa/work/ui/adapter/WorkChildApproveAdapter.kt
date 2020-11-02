package org.alieoa.work.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.alieoa.work.R
import org.alieoa.work.entity.ApproveBean

class WorkChildApproveAdapter(val layoutId: Int) :
    RecyclerView.Adapter<WorkChildApproveAdapter.ViewHolder>() {

    var mData: ArrayList<ApproveBean>? = null
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.iv1.setImageResource(R.drawable.img_app_icon_go_out)
        holder.tv1.text = "xxx"
    }

    override fun getItemCount(): Int {
        return when (mData) {
            null -> 0
            else -> mData!!.size
        }
    }


    inner class ViewHolder(containerView: View) :
        RecyclerView.ViewHolder(containerView) {
        var tv1: TextView = containerView.findViewById(R.id.tv_content)
        var iv1: ImageView = containerView.findViewById(R.id.iv)

    }
}