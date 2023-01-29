package com.example.gamehunter.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamehunter.R
import com.google.firebase.auth.FirebaseAuth

class InitializeActivity : AppCompatActivity(){
    private val firebaseAuth = FirebaseAuth.getInstance()
    private lateinit var sharePreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharePreferences = getSharedPreferences(getString(R.string.preference_file_key),
            MODE_PRIVATE)

        val isLoggedIn =
            sharePreferences.getBoolean(getString(R.string.preference_is_logged_in), false)
        val email = sharePreferences.getString(getString(R.string.preference_email), "")
        val password = sharePreferences.getString(getString(R.string.preference_password), "")

        if(isLoggedIn && email != "" && password != "") {
            firebaseAuth.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}