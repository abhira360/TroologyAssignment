package com.assignment.troologyassignmentapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.troologyassignmentapplication.model.GetDashboardDataResponse
import com.assignment.troologyassignmentapplication.repository.Repository
import kotlinx.coroutines.*
import java.lang.Exception

class DashboardDataViewModel: ViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throw Exception(throwable.localizedMessage)
    }
    val dashboardDataResponse = MutableLiveData<List<GetDashboardDataResponse>>()

    fun getDashboardData(customKey: String,
                         districtId: String,
                         tehsilId: String )
    {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            withContext(Dispatchers.Main) {
                val response = Repository().getMADashboard(customKey, districtId, tehsilId)
                dashboardDataResponse.value = response
            }
        }
    }

}