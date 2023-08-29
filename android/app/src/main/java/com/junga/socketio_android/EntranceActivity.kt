package com.junga.socketio_android

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_entrance.*
import org.jetbrains.anko.startActivity

class EntranceActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        button.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button -> enterChatRoom()
        }
    }

    private fun enterChatRoom() {
        val userName = userNameEditText.text
        val roomName = roomNameEditText.text

        if (!roomName.isNullOrEmpty() && !userName.isNullOrEmpty()) {
            startActivity<ChatRoomActivity>(
                "userName" to userName,
                "roomName" to roomName
            )
        } else {
            Snackbar.make(constraintLayout, getString(R.string.emptyMessage), Snackbar.LENGTH_LONG)
                .setAction("OK") {}
                .show()
        }
    }
}
