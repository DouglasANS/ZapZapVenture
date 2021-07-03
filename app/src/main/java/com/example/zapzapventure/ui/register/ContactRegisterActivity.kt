package com.example.zapzapventure.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.zapzapventure.databinding.ActivityContactRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ContactRegisterActivity : AppCompatActivity() {

    private val TAG = "Teste 2"
    private lateinit var binding: ActivityContactRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* fun AdicionarContato(){

            var nome = binding.txtName.text.toString()
            var email = binding.txtE.text.toString()

            val current = FirebaseAuth.getInstance().currentUser

            val item = hashMapOf(
                "name" to nome,
                "email" to email,
            )

            val db1 = FirebaseFirestore.getInstance().collection("users").document(current!!.email!!)
                .collection("contacts")
                .document(email)
                .set(item)
                .addOnCompleteListener {
                    Log.d(TAG, "Deu bom!")
                }.addOnFailureListener{e -> Log.w(TAG, "Deu ruim", e)}
        }
*/
    }
}