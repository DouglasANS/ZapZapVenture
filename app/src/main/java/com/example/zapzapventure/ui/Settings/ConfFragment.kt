package com.example.zapzapventure.ui.Settings

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.zapzapventure.LoginActivity
import com.example.zapzapventure.databinding.FragmentConfBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ConfFragment : Fragment() {

    private lateinit var confViewModel: ConfViewModel
    private var _binding: FragmentConfBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        confViewModel =
            ViewModelProvider(this).get(ConfViewModel::class.java)

        _binding = FragmentConfBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textConf
        confViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        binding.btnsair.setOnClickListener {
            Firebase.auth.signOut()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}