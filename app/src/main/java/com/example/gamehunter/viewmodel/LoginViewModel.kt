package com.example.gamehunter.viewmodel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gamehunter.view.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(private val context: Context) : ViewModel() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()


    fun login() {
        firebaseAuth.signInWithEmailAndPassword(email.value!!, password.value!!)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                } else {
                    error.value = task.exception?.message
                }
            }
    }


    fun signUp() {
        firebaseAuth.createUserWithEmailAndPassword(email.value!!, password.value!!)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    success.value = true

                } else {
                    error.value = task.exception?.message
                }
            }
    }

    fun logout() {
        firebaseAuth.signOut()
    }
}


