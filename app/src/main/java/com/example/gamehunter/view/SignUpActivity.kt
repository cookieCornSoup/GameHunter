package com.example.gamehunter.view

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamehunter.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)

        binding.signupButton.setOnClickListener {
            val email = binding.emailEdittext.text.toString()
            val password = binding.passwordEdittext.text.toString()
            val passwordConfirm = binding.passwordConfirmEdittext.text.toString()

            if (validateForm(email,password)) {
                if (password == passwordConfirm) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this,
                                    "회원가입이 성공적으로 진행되었습니다. 이제 로그인이 가능합니다.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    this,
                                    "회원 가입 실패 : ${task.exception?.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    Toast.makeText(
                        this,
                        "비밀번호가 확인과 일치하지 않습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun validateForm(email: String, password: String): Boolean {
        var valid = true
        if (TextUtils.isEmpty(email)) {
            binding.emailEdittext.error = "이메일은 필수 입력입니다."
            valid = false
        } else {
            binding.emailEdittext.error = null
        }

        if (TextUtils.isEmpty(password)) {
            binding.passwordEdittext.error = "비밀번호는 필수 입력입니다."
            valid = false
        } else {
            binding.passwordEdittext.error = null
        }
        // 추가적인 비밀번호 검증 코드 작성 가능
        return valid
    }

}
