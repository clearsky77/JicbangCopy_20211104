package com.clearsky77.jicbangcopy_20211104.datas

import java.text.NumberFormat
import java.util.*

class RoomData(
    val price : Int,
    val address : String,
    val floor : Int,
    val description : String
) {

    fun getFormattedPrice() : String {
        if(this.price < 10000){
            val priceStr = NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)
            return priceStr
        }else{
            val priceStr = NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)
            return priceStr
        }
    }

}