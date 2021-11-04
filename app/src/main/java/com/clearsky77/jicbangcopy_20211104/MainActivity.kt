package com.clearsky77.jicbangcopy_20211104

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clearsky77.jicbangcopy_20211104.adapters.RoomAdapter
import com.clearsky77.jicbangcopy_20211104.datas.RoomData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//  방 데이터를 담아두기 위한 목록 변수
    val mRooms = ArrayList<RoomData>()
    lateinit var mRoomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRooms.add(RoomData(8000,"서울시 동대문구",5,"1번째 방입니다."))
        mRooms.add(RoomData(18000,"서울시 성북구",5,"2번째 방입니다."))
        mRooms.add(RoomData(8000,"서울시 강남구",5,"3번째 방입니다."))
        mRooms.add(RoomData(5000,"서울시 강동구",5,"4번째 방입니다."))
        mRooms.add(RoomData(10000,"경기도 고양시",5,"5번째 방입니다."))
        mRooms.add(RoomData(7000,"성남시 분당구",5,"6번째 방입니다."))

        mRoomAdapter = RoomAdapter(this, R.layout.room_list_item, mRooms)
        roomListView.adapter = mRoomAdapter

        roomListView.setOnItemClickListener { adapterView, view, position, l ->
            val ClickedRoom = mRooms[position]

            val myIntent = Intent(this, ViewRoomDetailActivity :: class.java)
            myIntent.putExtra("room", ClickedRoom)



            startActivity(myIntent)
        }
    }
}