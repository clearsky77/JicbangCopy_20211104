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
            val uk = this.price / 10000
            val rest = this.price % 10000
            val restCommaStr = NumberFormat.getNumberInstance(Locale.KOREA).format(rest)

            val priceStr = "${uk}억 ${restCommaStr}"

            return priceStr
        }
    }

    fun getFormattedFloor() : String {
        if(this.floor>0){
            return "${this.floor}층"
        }else if(this.floor==0){
            return "반지하"
        }else{
            return "${-this.floor}층"
        }

    }


}