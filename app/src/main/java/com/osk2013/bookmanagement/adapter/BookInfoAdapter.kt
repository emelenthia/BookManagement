package com.osk2013.bookmanagement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import com.osk2013.bookmanagement.R
import com.osk2013.bookmanagement.ViewHolder
import com.osk2013.bookmanagement.dto.BookInfoDto
import io.realm.Realm
import kotlinx.android.synthetic.main.book_info_cell.view.*
import java.text.FieldPosition

open class BookInfoAdapter(context: Context, bookInfos: List<BookInfoDto>) : ArrayAdapter<BookInfoDto>(context, 0, bookInfos) {

    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        var holder: ViewHolder

        if(view == null) {
            view = layoutInflater.inflate(R.layout.book_info_cell, parent, false)
            holder = ViewHolder(
                view?.title_text_view!!,
                view.date_text_view,
                view.imageView2
            )
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val bookInfo = getItem(position) as BookInfoDto
        holder.titleTextView.text = bookInfo.title
        holder.dateTextView.text = "2019/12/11"//bookInfo.releaseDate



        return view
    }

}