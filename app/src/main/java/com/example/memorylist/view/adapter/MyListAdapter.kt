package com.example.memorylist.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.memorylist.model.Memory
import com.example.memorylist.R
import java.text.DateFormat
import java.util.*
import kotlin.collections.ArrayList

class MyListAdapter(
    private val mContext: Context,
    private val myMemories: ArrayList<Memory>,
    private val nowButtonClicked: (Int) -> Unit
) : BaseAdapter() {

    private val altColor = Color.parseColor("#CBDBEC")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowMain = LayoutInflater.from(mContext).inflate(R.layout.memory_row, parent, false)
        if (position % 2 == 0)
            rowMain.setBackgroundColor(altColor)
        val mem = myMemories[position]
        rowMain.findViewById<TextView>(R.id.row_title).text = mem.name
        rowMain.findViewById<TextView>(R.id.row_date).text = reFormat(mem.lasTime)
        rowMain.findViewById<TextView>(R.id.button_now).setOnClickListener {nowButtonClicked(position)}
        val imageView = rowMain.findViewById<ImageView>(R.id.resv_row_img)
     //   if (resv.img != null)
         //   Picasso.get().load(resv.img).into(imageView)
        return rowMain
    }
    private val format = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.FRANCE)
    private fun reFormat(date: Date):String{
        return format.format(date)
    }
    override fun getItem(position: Int): Memory = myMemories[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = myMemories.size
}