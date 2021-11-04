package com.clearsky77.jicbangcopy_20211104.datas

import java.io.Serializable
import java.text.NumberFormat
import java.util.*

class RoomData(
    val price : Int,
    val address : String,
    val floor : Int,
    val description : String) : Serializable {

    fun getFormattedPrice() : String {
        if(this.price < 10000){
            val priceStr = NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)
            return priceStr
        }else{
            val uk = this.price / 10000
            val rest = this.price % 10000
            val restCommaStr = NumberFormat.getNumberInstance(Locale.KOREA).format(rest)

            // 억으로 떨어지면 뒤에 0이 붙지 않도록
            if(price % 10000 == 0){
                return "${uk}억"
            }else{
                return "${uk}억 ${restCommaStr}"
            }
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