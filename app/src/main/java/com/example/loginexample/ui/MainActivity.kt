package com.example.loginexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginexample.R
import com.example.loginexample.data.model.web.UserResponse
import com.example.loginexample.databinding.ActivityMainBinding
import com.example.loginexample.ui.utils.adapter.UserAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            mainViewModel.getAllUsers().collect{
                when(it){
                    is UserResponse -> {
                        binding.rcvUser.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = UserAdapter(it)
                        }
                    }

                    is Exception -> {
                        Log.e("TAG", "onCreate: $it ", )
                    }
                }
            }
        }
    }
}