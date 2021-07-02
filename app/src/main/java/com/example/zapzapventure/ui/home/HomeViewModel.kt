package com.example.zapzapventure.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zapzapventure.model.Contact
import com.example.zapzapventure.repository.UserRepository

class HomeViewModel : ViewModel() {

    private val _ContactsList = MutableLiveData<ArrayList<Contact>>().apply {
        UserRepository.getMyContacts{
            value = it
        }
    }
    val contactList: MutableLiveData<ArrayList<Contact>> = _ContactsList
}