package com.clearsky77.jicbangcopy_20211104

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clearsky77.jicbangcopy_20211104.adapters.RoomAdapter
import com.clearsky77.jicbangcopy_20211104.datas.RoomData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRooms = ArrayList<RoomData>() //  방 데이터를 담아두기 위한 목록 변수
    lateinit var mRoomAdapter: RoomAdapter // 룸 어댑터를 담기 위한 변수. 바깥에서 선언해서 class내부 어디서든 쓸수 있게.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 데이터 하드 코딩 입력
        mRooms.add(RoomData(8000,"서울시 동대문구",5,"1번째 방입니다."))
        // 방 데이터 리스트.추가한다(룸 데이터 클래스 모양의 객체를)
        mRooms.add(RoomData(18000,"서울시 성북구",5,"2번째 방입니다."))
        mRooms.add(RoomData(8000,"서울시 강남구",5,"3번째 방입니다."))
        mRooms.add(RoomData(5000,"서울시 강동구",5,"4번째 방입니다."))
        mRooms.add(RoomData(10000,"경기도 고양시",5,"5번째 방입니다."))
        mRooms.add(RoomData(7000,"성남시 분당구",5,"6번째 방입니다."))

        mRoomAdapter = RoomAdapter(this, R.layout.room_list_item, mRooms)
        // 룸 어댑터 변수에 룸 어댑터 객체를 생성한다. (여기에, room_list_item 모양으로, 데이터는 룸 리스트를)
        roomListView.adapter = mRoomAdapter
        // 룸 리스트 뷰(xml에 있는 아이디임)에 어댑터는 방금 생성한 어댑터를 연결시켜준다.
    }
}