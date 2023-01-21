package com.example.gamehunter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gamehunter.databinding.ActivitySignupBinding
import com.example.gamehunter.viewmodel.LoginViewModel

class SignUpActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.signupButton.setOnClickListener {
            viewModel.email.value = binding.emailEdittext.text.toString()
            viewModel.password.value = binding.passwordEdittext.text.toString()
            viewModel.signUp()
        }
    }
}

