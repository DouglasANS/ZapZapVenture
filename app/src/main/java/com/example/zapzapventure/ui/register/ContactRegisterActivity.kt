package com.example.zapzapventure.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zapzapventure.databinding.ActivityContactRegisterBinding

class ContactRegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}