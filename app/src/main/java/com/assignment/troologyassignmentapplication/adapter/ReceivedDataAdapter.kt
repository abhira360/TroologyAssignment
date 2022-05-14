package com.assignment.troologyassignmentapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.troologyassignmentapplication.R
import com.assignment.troologyassignmentapplication.model.ReceivedDataResponse

class ReceivedDataAdapter(
    private val list: List<ReceivedDataResponse>,
): RecyclerView.Adapter<ReceivedDataAdapter.ReceivedDataViewHolder>() {

    inner class ReceivedDataViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val serialNumber: TextView = view.findViewById(R.id.tv_serial_number)
        val districtName: TextView = view.findViewById(R.id.tv_district_name)
        val count: TextView = view.findViewById(R.id.tv_count)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceivedDataViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_received_data,parent,false)
        return ReceivedDataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReceivedDataViewHolder, position: Int) {
        val data = list[position]
        val serialNumber = position+1
        holder.serialNumber.text = serialNumber.toString()
        holder.districtName.text = data.DistrictName
        holder.count.text = data.TOTAL

    }

    override fun getItemCount(): Int {
        return list.size
    }

}