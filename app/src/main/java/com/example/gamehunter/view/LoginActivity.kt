
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gamehunter.databinding.ActivityLoginBinding
import com.example.gamehunter.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.buttonSignUp.setOnClickListener {
            viewModel.email.value = binding.edittextEmail.text.toString()
            viewModel.password.value = binding.edittextPassword.text.toString()
            viewModel.signUp()
        }

        binding.buttonLogIn.setOnClickListener {
            viewModel.email.value = binding.edittextEmail.text.toString()
            viewModel.password.value = binding.edittextPassword.text.toString()
            viewModel.login()
        }
    }
}


