package com.assignment.troologyassignmentapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.troologyassignmentapplication.adapter.ReceivedDataAdapter
import com.assignment.troologyassignmentapplication.databinding.ActivityReceivedBinding
import com.assignment.troologyassignmentapplication.viewmodel.ReceivedDataViewModel

class ReceivedActivity : AppCompatActivity() {

    lateinit var viewModel : ReceivedDataViewModel
    lateinit var binding: ActivityReceivedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceivedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ReceivedDataViewModel::class.java]
        viewModel.getReceivedData("m@b1l3app","1","1","0","0","0")


        observeViewModel()
        binding.tvBackInReceived.setOnClickListener {
            this.onBackPressed()
        }
    }

    private fun observeViewModel() {
        viewModel.receivedDataResponse.observe(this, Observer {
            it.let {


                binding.tvPurposeReceived.text =  it[0].PurposeType
                binding.tvCountText.text = it[0].DistrictId
                val mAdapter = ReceivedDataAdapter(it)
                val layoutManager = LinearLayoutManager(this)
                binding.rvDataReceived.layoutManager = layoutManager
                binding.rvDataReceived.itemAnimator = DefaultItemAnimator()
                binding.rvDataReceived.adapter = mAdapter
            }
        })

    }
}
