package org.alieoa.work.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.alieoa.work.R
import org.alieoa.work.test.TestContact
import org.alieoa.work.universal.function.FunctionText

class TopContactAdapter(var context: Context) : BaseAdapter() {
    var mList: ArrayList<TestContact>? = null
        private set

    private val mInflater = LayoutInflater.from(context)
    private var mFunctionText = FunctionText()

    fun setData(data: ArrayList<TestContact>?) {
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
        val testContact = mList?.get(position)
        var vh: ViewHolder? = null
        var view = convertView
        when (convertView) {
            null -> {
                vh = ViewHolder()
                view = mInflater.inflate(R.layout.item_top_contact, null)
                vh.iv_user_head = view.findViewById(R.id.iv_user_head)
                vh.tv_contact_name = view.findViewById(R.id.tv_contact_name)
                view.tag = vh
            }
            else -> {
                vh = view?.tag as ViewHolder
            }
        }
        vh.tv_contact_name.text = testContact?.name
        return view!!
    }


    inner class ViewHolder {
        lateinit var iv_user_head: ImageView
        lateinit var tv_contact_name: TextView
    }


}