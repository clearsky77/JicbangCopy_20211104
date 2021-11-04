package com.clearsky77.jicbangcopy_20211104.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.clearsky77.jicbangcopy_20211104.datas.RoomData

class RoomAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<RoomData>) : ArrayAdapter<RoomData>(mContext, resId, mList){
}