package com.example.zapzapventure.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.zapzapventure.ui.chat.ChatActivity
import com.example.zapzapventure.databinding.FragmentHomeBinding
import com.example.zapzapventure.model.Contact
import com.example.zapzapventure.repository.ChatRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private val TAG = "Teste"
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val contactsList: RecyclerView = binding.RecyclerListId
        val adapter: HomeAdapter = HomeAdapter{
            contact -> onContactSelected(contact)
        }
        homeViewModel.contactList.observe(viewLifecycleOwner, Observer {
            adapter.setContactsList(it)
        })
        contactsList.adapter = adapter

        val current = FirebaseAuth.getInstance().currentUser

        if (current != null) {
           binding.textNameWelcome.text = "Bem Vindo: ${current.displayName}"
            binding.textEmailWelcome.text = " E-mail: ${current.email}"
        }

        return root
    }

    private fun onContactSelected(contact: Contact) {
        ChatRepository.getChatWith(contact.email) { chatId, e ->
            if (e != null) {
                Toast.makeText(context, e, Toast.LENGTH_LONG).show()
            } else {
                goToChat(chatId)
            }
        }
    }

    private fun goToChat(chatId: String) {
        val intent: Intent = Intent(context, ChatActivity::class.java)
        intent.putExtra(
            "chatId",
            chatId
        )
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}