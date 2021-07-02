package com.example.zapzapventure.ui.dashboard

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zapzapventure.databinding.FragmentDashboardBinding
import com.example.zapzapventure.model.Contact
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class DashboardFragment : Fragment() {

    private val TAG = "Teste 2"
    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //val db3 = FirebaseFirestore.getInstance()

        val nome = binding.etAdicionarName.text.toString()
        val email = binding.etAdicionarEmail.text.toString()

        val current = FirebaseAuth.getInstance().currentUser

        val item = hashMapOf(
            "name" to nome,
            "email" to email
        )
        binding.adicionarValor.setOnClickListener {
            val db1 = FirebaseFirestore.getInstance().document("users/${current!!.email}")
            db1.collection("contacts").document(email).set(item).addOnCompleteListener { Log.d(TAG, "Deu bom!")  }.addOnFailureListener{e -> Log.w(TAG, "Deu ruim", e)}
        }



        //val usuario = hashMapOf(
        //    "name" to nome.toString(),
        //    "email" to email.toString()
        //)
        // binding.adicionarValor.setOnClickListener {
        //     db3.collection("users").document("asssssad" /*currentuser*/ ).set(usuario)
        //        .addOnSuccessListener { Log.d(TAG, "Deu bom!") }
        //        .addOnFailureListener { e -> Log.w(TAG, "Deu ruim", e) }
        // }


        //val newUser = db.collection("users").document()

        //newUser.set("asdasda@hotmail.com")


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}