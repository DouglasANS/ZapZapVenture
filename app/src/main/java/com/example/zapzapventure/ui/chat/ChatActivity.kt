package com.example.zapzapventure.ui.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val messages = binding.messages

        /*ChatRepository.getMessages(chatId){
            messages.text.clear()
            for(msg in it){
                messages.text.append("${msg.message}\n")
            }
        }

        binding.btnSend.setOnClickListener{
            val msg = binding.txtMessage.text.toString()

            if (me != null) {
                ChatRepository.addMessageToChat(chatId, me, msg)
            }
        }*/

    }
}