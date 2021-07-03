package com.example.zapzapventure.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.zapzapventure.R
import com.example.zapzapventure.model.Message
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatAdapter(val onChatSelected: (message: Message) -> Unit) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    var chat: ArrayList<Message> = ArrayList<Message>()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val MessageSend: EditText = itemView.findViewById(R.id.txtMessage)
        private val MessageText: EditText = itemView.findViewById(R.id.txtMessage)
        val sendButton: FloatingActionButton = itemView.findViewById(R.id.btnSend)

        fun setChat(chat: Message){

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_chat_list, parent,false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        holder.setChat(chat[position])
        holder.sendButton.setOnClickListener {
            onChatSelected(chat[position])
        }
    }

    override fun getItemCount(): Int {
        return chat.size
    }

}