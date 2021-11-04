package com.clearsky77.jicbangcopy_20211104.datas

import java.text.NumberFormat
import java.util.*

class RoomData( //룸 데이터 하나. 생성할 때에 입력해야 하는 파라미터는 아래와 같다.
    val price : Int, // 가격을 숫자형식으로
    val address : String, // 주소를 문자 형식으로
    val floor : Int, // 층수를 숫자 형식으로
    val description : String // 설명을 문자 형식으로
) {

    // 변형된 가격형식을 반환하는 함수
    fun getFormattedPrice() : String { // 사용할 때 파라미터 없음. 스트링 형식으로 반환한다.
        if(this.price < 10000){ // 10000보다 작으면
            val priceStr = NumberFormat.getNumberInstance(Locale.KOREA).format(this.price) //한국 형식 천단위로 변형하여 문자 형식반환
            return priceStr // 반환
        }else{
            val uk = this.price / 10000 // 억 단위 구하기
            val rest = this.price % 10000 // 억을 제외한 나머지 구하기
            val restCommaStr = NumberFormat.getNumberInstance(Locale.KOREA).format(rest) // 나머지에 천단위 콤마 붙이기

            // 억으로 떨어지면 뒤에 0이 붙지 않도록
            if(price % 10000 == 0){ // 억으로 떨어지면
                return "${uk}억" // 억만 반환한다.
            }else{
                return "${uk}억 ${restCommaStr}" // 억과 나머지를 함께 반환.
            }
        }
    }

    // 층수를 반환하는 함수
    fun getFormattedFloor() : String { // 파라미터는 필요 없고, 문자로 반환한다
        if(this.floor>0){ // 만약 0보다 많으면
            return "${this.floor}층" // 층을 붙인다.
        }else if(this.floor==0){ // 0이면
            return "반지하" // 반지하
        }else{
            return "지하 ${-this.floor}층" // 그 외에는 지하
        }

    }


}