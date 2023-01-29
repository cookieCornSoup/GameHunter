package com.example.gamehunter.viewmodel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gamehunter.view.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(private val context: Context) : ViewModel() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    val error = MutableLiveData<String>()

    fun checkEmailExist(email: String, callback: (exist: Boolean) -> Unit) {
        firebaseAuth.fetchSignInMethodsForEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val signInMethods = task.result?.signInMethods
                    callback(signInMethods?.contains("password") == true)
                } else {
                    error.value = task.exception?.message
                }
            }
    }

    fun checkEmailPassword(email: String, password: String, callback: (success: Boolean) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(true)
                } else {
                    error.value = task.exception?.message
                    callback(false)
                }
            }
    }

    fun logout() {
        firebaseAuth.signOut()
    }
}


