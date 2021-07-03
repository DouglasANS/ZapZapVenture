package com.example.zapzapventure.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zapzapventure.R
import com.example.zapzapventure.model.Message
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.collections.ArrayList

class ChatAdapter() : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    var messages: ArrayList<Message> = ArrayList<Message>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val MessageSend: TextView = itemView.findViewById(R.id.send_message)
        private val MessageTime: TextView = itemView.findViewById(R.id.messageTime)

        fun setMessage(msg: Message){
            MessageSend.text = msg.message
            MessageTime.text = timeToString(msg.time)
        }

        private fun timeToString(time: Long): String {
            val date = Date(time)
            return date.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_chat_list, parent,false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        holder.setMessage(messages[position])
    }

    override fun getItemCount(): Int {
        return messages.size
    }

}