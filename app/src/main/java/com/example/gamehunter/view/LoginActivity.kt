package com.example.gamehunter.view
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gamehunter.R
import com.example.gamehunter.databinding.ActivityLoginBinding
import com.example.gamehunter.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // LoginViewModel을 인스턴스화 하고 이를 viewModel에 할당
        // 이로인해서 viewModel은 LoginActivity의 생명 주기를 가지게 되며 데이터를 유지할 수 있음
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        // 계속하기 버튼을 눌렀을 때, 이메일이 빈 칸일 때 나오는 에러 메시지 출력
        binding.buttonCheckUser.setOnClickListener {
            val email = binding.edittextEmail.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, getString(R.string.loginError_emailError), Toast.LENGTH_SHORT)
                    .show()
            }

            viewModel.checkEmailExist(email) { exist ->
                if (exist) {
                    binding.edittextEmail.isEnabled = false
                    binding.edittextPassword.visibility = View.VISIBLE
                    binding.edittextPassword.requestFocus()
                } else {
                    Toast.makeText(this, getString(R.string.signUpToast), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, SignUpActivity::class.java))
                }
            }

        }

        binding.edittextPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val email = binding.edittextEmail.text.toString()
                val password = binding.edittextPassword.text.toString()

                viewModel.checkEmailPassword(email, password) { success ->
                    if (success) {
                        Toast.makeText(
                            this,
                            getString(R.string.login_succesText),
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Toast.makeText(this, getString(R.string.login_failText), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
            false
        }

    }
}