package com.assignment.troologyassignmentapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.assignment.troologyassignmentapplication.R
import com.assignment.troologyassignmentapplication.databinding.ActivityInProcessBinding
import com.assignment.troologyassignmentapplication.viewmodel.InProcessDataViewModel

class InProcessActivity : AppCompatActivity() {

    lateinit var viewModel: InProcessDataViewModel
    lateinit var binding: ActivityInProcessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBarInProcess.visibility = View.VISIBLE
        viewModel = ViewModelProvider(this)[InProcessDataViewModel::class.java]
        viewModel.getInProcessData("m@b1l3app","1","1","0","0","0","query")

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.inProcessDataResponse.observe(this, Observer {
            it.let {

                binding.progressBarInProcess.visibility = View.GONE
                binding.tvTotalCount.text = "Total: " + it[0].TOTAL
                binding.tvUnderQuery.text = it[0].ApplicationCategory + " :"

            }
        })
    }
}