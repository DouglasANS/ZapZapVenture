package com.example.zapzapventure.ui.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.recyclerview.widget.RecyclerView
import com.example.zapzapventure.databinding.ActivityChatBinding
import com.example.zapzapventure.repository.ChatRepository
import com.example.zapzapventure.repository.UserRepository

class ChatActivity : AppCompatActivity() {
    lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chatId = intent.getStringExtra("chatId")
        if(chatId == null) {
            finish()
            return
        }

        val me = UserRepository.myEmail()

        val chatList: RecyclerView = binding.messages
        val adapter: ChatAdapter = ChatAdapter()

        chatList.adapter = adapter

        ChatRepository.getMessages(chatId){
            adapter.messages = it
        }

        binding.btnSend.setOnClickListener{
            val msg = binding.txtMessage.text.toString()

            if (me != null) {
                ChatRepository.addMessageToChat(chatId, me, msg)
            }
        }

    }
}