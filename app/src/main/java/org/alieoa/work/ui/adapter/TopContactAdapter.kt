package org.alieoa.work.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.alieoa.work.R
import org.alieoa.work.entity.FrequentContact
import org.alieoa.work.ui.widget.view.CircleImgView
import org.alieoa.work.universal.function.FunctionText

class TopContactAdapter(var context: Context) : BaseAdapter() {
    var mList: ArrayList<FrequentContact>? = null
        private set

    private val mInflater = LayoutInflater.from(context)
    private var mFunctionText = FunctionText()

    fun setData(data: ArrayList<FrequentContact>?) {
        mList = data ?: ArrayList()
        notifyDataSetChanged()
    }

    override fun getCount(): Int = when (mList) {
        null -> 0
        else -> mList!!.size
    }

    override fun getItem(position: Int): Any = when (mList) {
        null -> null
        else -> mList!![position]
    }!!


    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val frequentContact = mList?.get(position)
        var vh: ViewHolder? = null
        var view = convertView
        when (convertView) {
            null -> {
                vh = ViewHolder()
                view = mInflater.inflate(R.layout.item_top_contact, parent,false)
                vh.iv_user_head = view.findViewById(R.id.iv_user_head)
                vh.tv_contact_name = view.findViewById(R.id.tv_contact_name)
                view.tag = vh
            }
            else -> {
                vh = view?.tag as ViewHolder
            }
        }
        vh.tv_contact_name.text = frequentContact?.name
        vh.iv_user_head.doDrawText(mFunctionText.generateTargetName(frequentContact?.name!!));
        return view!!
    }


    inner class ViewHolder {
        lateinit var iv_user_head: CircleImgView
        lateinit var tv_contact_name: TextView
    }


}