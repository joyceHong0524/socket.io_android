/**
 * @author Joyce Hong
 * @email soja0524@gmail.com
 * @created 2019-09-03
 * @desc
 */

package com.junga.socketio_android

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatRoomAdapter(val context : Context, val chatList : ArrayList<Message>) : RecyclerView.Adapter<ChatRoomAdapter.ViewHolder>(){

    val CHAT_MINE = 0
    val CHAT_PARTNER = 1
    val USER_JOIN = 2
    val USER_LEAVE = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        Log.d("chatlist size",chatList.size.toString())
        var view : View? = null
        when(viewType){

            0 ->{
                view = LayoutInflater.from(context).inflate(R.layout.row_chat_user,parent,false)
                Log.d("user inflating","viewType : ${viewType}")
            }

            1 ->
            {
                view = LayoutInflater.from(context).inflate(R.layout.row_chat_partner,parent,false)
                Log.d("partner inflating","viewType : ${viewType}")
            }
            2 -> {
                view = LayoutInflater.from(context).inflate(R.layout.chat_into_notification,parent,false)
                Log.d("someone in or out","viewType : ${viewType}")
            }
            3 -> {
                view = LayoutInflater.from(context).inflate(R.layout.chat_into_notification,parent,false)
                Log.d("someone in or out","viewType : ${viewType}")
            }
        }

        return ViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun getItemViewType(position: Int): Int {
        return chatList[position].viewType
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val messageData  = chatList[position]
        val userName = messageData.userName;
        val content = messageData.messageContent;
        val viewType = messageData.viewType;

        when(viewType) {

            CHAT_MINE -> {
                holder.message.setText(content)
            }
            CHAT_PARTNER ->{
                holder.userName.setText(userName)
                holder.message.setText(content)
            }
            USER_JOIN -> {
                val text = "${userName} has entered the room"
                holder.text.setText(text)
            }
            USER_LEAVE -> {
                val text = "${userName} has leaved the room"
                holder.text.setText(text)
            }
        }

    }
    inner class ViewHolder(itemView : View):  RecyclerView.ViewHolder(itemView) {
        val userName = itemView.findViewById<TextView>(R.id.username)
        val message = itemView.findViewById<TextView>(R.id.message)
        val text = itemView.findViewById<TextView>(R.id.text)
    }

}