package com.example.zapzapventure.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.zapzapventure.databinding.FragmentHomeBinding
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
        val adapter: HomeAdapter = HomeAdapter()
        homeViewModel.contactList.observe(viewLifecycleOwner, Observer {
            adapter.setContactsList(it)
        })

        val db = Firebase.firestore

        val current = FirebaseAuth.getInstance().currentUser

        if (current != null) {
           binding.textNameWelcome.text = "Bem Vindo: ${current.displayName}"
            binding.textEmailWelcome.text = " So para lembrar seu email é: ${current.email}"
        }

        contactsList.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}