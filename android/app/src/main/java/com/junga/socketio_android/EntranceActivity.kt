package com.junga.socketio_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_entrance.*
import kotlinx.android.synthetic.main.activity_entrance.view.*
import kotlinx.android.synthetic.main.activity_entrance.view.nickname
import org.jetbrains.anko.startActivity

class EntranceActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

    }


    override fun onClick(p0: View?) {
            when(p0?.id){
                R.id.button -> enterChatroom()
            }
    }

    private fun enterChatroom(){
        val nickName = nickname.text.toString()
        val roomName = roomname.text.toString()
        startActivity<ChatRoomActivity>("nickName" to nickName,
                                                "roomName" to roomName)
    }
}
