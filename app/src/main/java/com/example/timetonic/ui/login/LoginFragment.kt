package com.example.timetonic.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.timetonic.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val appKey = "TRfC-d44Z-uru3-7YrT-hiEh-XJau-t5rC"

            viewModel.authenticate(email, password, appKey, { sesskey ->
                Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToBooksFragment(sesskey))
            }, { error ->
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            })
        }
    }
}