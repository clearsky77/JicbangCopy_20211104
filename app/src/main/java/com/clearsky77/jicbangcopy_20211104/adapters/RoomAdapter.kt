package com.clearsky77.jicbangcopy_20211104.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.clearsky77.jicbangcopy_20211104.R
import com.clearsky77.jicbangcopy_20211104.datas.RoomData

class RoomAdapter( // 인스턴스 생성시 필요한 파라미터는
    val mContext: Context, // 보여줄 위치
    val resId: Int, // 아이템 틀(그릇 모양) 여기서는 room_list_item가 들어 올 것이다.
    val mList: ArrayList<RoomData>) // 보여줄 데이터
: ArrayAdapter<RoomData>(mContext, resId, mList){ // 부모에게 넘겨준다

    val mInflater = LayoutInflater.from(mContext) // convertView가 없다면 생성해줄 인플레이터
                                    // .from(어디에 보여줄 것인지 위치)

    // 부모인 ArrayAdapter가 가지고 있는 getView를 오버라이딩 한다.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 자동으로 for문을 도는데
        // position은 i에 해당, convertView는 화면에 보여줄 그릇(판)인데 ?표는 없을 수도 있다는 뜻. 돌려막기하는 그릇(판).
        // View를 상속받았다.
        var tempRow = convertView // null인지 판별하기 위해서 변수에 넣는다.
        if(tempRow==null){ // null이면 현재 i번째 출력을 할 convertView가 없다는 것이므로
            tempRow = mInflater.inflate(R.layout.room_list_item, null)
            // 미리 만들어 놓은 mInflater로 room_list_item모양의 판을 제작해서 준다! 옛다! ~ㅂ~)/ 툭.
        }

        val row = tempRow!! // 흠흠 장인이 다 만들어 두었으니 null일리는 없을게야 후훗 <(~_~)> !!
        // !! 표시를 하고 row에 넘겨줘야, 밑에서 사용할 때 !!를 계속 명시하는 번거로움을 덜 수 있다.
        // !! 깜짝, !! 깜짝... 귀찮고 놀란다... 훠~이

        val roomData = mList[position]
        // 이번 i에 해당하는 데이터를 roomData에 넣어주고

        // xml에서의 위치 찾기. 각각 위치를 명시해둬야 갖다 붙일 수 있다.
        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)
                    //판에.아이디 찾아라<텍스트뷰>
        val txtAddressAndFloor = row.findViewById<TextView>(R.id.txtAddressAndFloor)
        val txtDescription = row.findViewById<TextView>(R.id.txtDescription)

        txtPrice.text = roomData.getFormattedPrice() // roomData에서 만들어 놓은 함수를 이용해 가격 문자를 받는다.
        txtDescription.text = roomData.description // 설명은 바로 붙여주고
        txtAddressAndFloor.text = "${roomData.address}, ${roomData.getFormattedFloor()}" // 주소와 층수(함수 사용)도 붙인다.

        return row // 제작 완료한 한 줄을 반환한다

    }

}