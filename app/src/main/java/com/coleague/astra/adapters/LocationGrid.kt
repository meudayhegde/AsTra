package com.coleague.astra.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.Toast


class LocationGridAdapter(block:Array<String>,level:Array<String>,area:Array<String>,room:Array<String>,context:Context) : BaseAdapter() {

    var block:ArrayList<String> = ArrayList()
    var level:ArrayList<String> = ArrayList()
    var area:ArrayList<String> = ArrayList()
    var room:ArrayList<String> = ArrayList()
    var context:Context=context

    init{
        for (i in block) this.block.add("Block "+i)
        for (i in level) this.level.add("Level "+i)
        for (i in area) this.area.add("Area "+i)
        for (i in room) this.room.add("Room "+i)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val spinner = Spinner(context)
        var spinnerArrayAdapter:ArrayAdapter<String>? = null
        when(position){
            0->{spinnerArrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, block) }
            1->{spinnerArrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, level) }
            2->{spinnerArrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, area) }
            3->{spinnerArrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, room) }
        }
        spinnerArrayAdapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerArrayAdapter
        return spinner
    }

    override fun getItem(position: Int): ArrayList<String> {

        when(position){
            0-> return block
            1-> return level
            2 -> return area
            3-> return room
        }
        return ArrayList()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return 4
    }
}