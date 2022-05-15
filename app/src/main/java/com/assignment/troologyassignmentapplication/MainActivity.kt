package com.assignment.troologyassignmentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.troologyassignmentapplication.adapter.DashboardViewAdapter
import com.assignment.troologyassignmentapplication.databinding.ActivityMainBinding
import com.assignment.troologyassignmentapplication.ui.InProcessActivity
import com.assignment.troologyassignmentapplication.ui.ReceivedActivity
import com.assignment.troologyassignmentapplication.viewmodel.DashboardDataViewModel

class MainActivity : AppCompatActivity(), DashboardViewAdapter.SelectInterface {

    lateinit var viewModel : DashboardDataViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressBar.visibility = View.VISIBLE
        viewModel = ViewModelProvider(this)[DashboardDataViewModel::class.java]
        viewModel.getDashboardData("m@b1l3app","0","0")

        binding.tvBackInDashboard.setOnClickListener {
            finish()
        }
        observeViewModel()
    }

    private fun observeViewModel() {

        viewModel.dashboardDataResponse.observe(this, Observer {
            it.let {
                binding.progressBar.visibility = View.GONE
                val mAdapter = DashboardViewAdapter(it,this)
                val layoutManager = LinearLayoutManager(this)
                binding.rvDashboard.layoutManager = layoutManager
                binding.rvDashboard.itemAnimator = DefaultItemAnimator()
                binding.rvDashboard.adapter = mAdapter

            }
        })

    }

    override fun openReceivedActivity() {
        val receivedActivity = Intent(this, ReceivedActivity::class.java)
        startActivity(receivedActivity)

    }

    override fun openInProcessActivity() {
        val inProcessActivity = Intent(this, InProcessActivity::class.java)
        startActivity(inProcessActivity)

    }

}