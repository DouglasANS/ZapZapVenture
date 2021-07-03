package com.example.zapzapventure

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.zapzapventure.model.User
import com.example.zapzapventure.repository.UserRepository
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val resultLaucher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        activityResult(result.resultCode, result.data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(Color.WHITE)

        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build() ,
            AuthUI.IdpConfig.GoogleBuilder().build()
            //provider
        )
        findViewById<Button>(R.id.btnLogin).setOnClickListener {

            resultLaucher.launch(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build()
            )
        }
    }
    private fun activityResult(resultCode: Int, data: Intent?) {
        val response = IdpResponse.fromResultIntent(data)

        if (resultCode == Activity.RESULT_OK) {
            // Successfully signed in
            val current = FirebaseAuth.getInstance().currentUser?.apply {
                val user: User = User(
                    name = this.displayName ?: "NO NAME",
                    email = this.email ?: "NO EMAIL"
                )
                UserRepository.addUser(user, {
                    goToMain()
                }, {
                    failToLogin(it)
                })
            }
        } else {
            failToLogin(response?.error?.message)
        }

    }

    fun failToLogin(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun goToMain() {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}