package com.assignment.troologyassignmentapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.troologyassignmentapplication.R
import com.assignment.troologyassignmentapplication.model.GetDashboardDataResponse

class DashboardViewAdapter(
    private val list: List<GetDashboardDataResponse>,
    val selectInterface: SelectInterface
): RecyclerView.Adapter<DashboardViewAdapter.DashboardViewHolder>() {

    interface SelectInterface {
        fun openReceivedActivity(){}
        fun openInProcessActivity(){}

    }

    inner class DashboardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val purpose: TextView = itemView.findViewById(R.id.tv_purpose)
        val receivedCount: TextView = itemView.findViewById(R.id.tv_received_count)
        val receivedLayout: LinearLayout = itemView.findViewById(R.id.rl_received)
        val approvedCount: TextView = itemView.findViewById(R.id.tv_approved_count)
        val inProcessCount: TextView = itemView.findViewById(R.id.tv_inProcess_count)
        val inProcessLayout: LinearLayout = itemView.findViewById(R.id.rl_inProcess)
        val rejectedCount: TextView = itemView.findViewById(R.id.tv_rejected_count)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_dashboard,parent,false)

        return DashboardViewHolder(item)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        val data = list[position]

        holder.purpose.text = data.PurposeType
        holder.receivedCount.text = data.RECEIVED
        holder.approvedCount.text = data.APPROVED
        holder.inProcessCount.text = data.INPROCESS
        holder.rejectedCount.text = data.REJECTED
        holder.receivedLayout.setOnClickListener {
            selectInterface.openReceivedActivity()
        }
        holder.inProcessLayout.setOnClickListener {
            selectInterface.openInProcessActivity()
        }



    }

    override fun getItemCount(): Int {
        return list.size
    }
}