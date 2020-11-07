package org.alieoa.basemvp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

open class BaseRvViewHolder(private var convertView: View) : RecyclerView.ViewHolder(convertView) {

    var mViews = HashMap<Int, View>()

    fun setText(viewId: Int, str: String?): BaseRvViewHolder {

        (getView(viewId) as TextView).run {
            text = str
        }
        return this
    }

    fun setText(viewId: Int, resId: Int): BaseRvViewHolder {
        (getView(viewId) as TextView).run {
            setText(resId)
        }
        return this
    }


    fun setImageResource(viewId: Int, resId: Int): BaseRvViewHolder {
        (getView(viewId) as ImageView).run {
            setImageResource(resId)
        }
        return this
    }


//    fun <T : View> getView(viewId: Int): T {
//        return convertView.findViewById(viewId) as T
//    }

    fun <T : View> getView(viewId: Int): T = mViews.let {
        var view = it[viewId]
        view ?: (convertView.findViewById(viewId) as T).also { targetView ->
            view = targetView
        }
        view as T
    }
}