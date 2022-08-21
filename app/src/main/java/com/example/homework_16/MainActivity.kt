package com.example.homework_16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_16.databinding.ActivityMainBinding
import com.example.homework_16.ui.UserAdapter
import com.example.homework_16.ui.LoadAdapter
import com.example.homework_16.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val userAdapter by lazy { UserAdapter() }

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        observers()
    }

    private fun init() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter.withLoadStateFooter(
                footer = LoadAdapter()
            )
        }
    }

    private fun observers() {
        lifecycleScope.launch {
            viewModel.getInfo().collect {
                userAdapter.submitData(it)
            }
        }
    }

}