package com.assignment.troologyassignmentapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.troologyassignmentapplication.model.ReceivedDataResponse
import com.assignment.troologyassignmentapplication.repository.Repository
import kotlinx.coroutines.*
import java.lang.Exception

class ReceivedDataViewModel: ViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throw Exception(throwable.localizedMessage)
    }

    val receivedDataResponse = MutableLiveData<List<ReceivedDataResponse>>()

    fun getReceivedData(customKey: String,
                        purpose: String,
                        status: String,
                        districtId: String,
                        tehsilId: String,
                        ruleTypeId: String
    ) {
        CoroutineScope(Dispatchers.IO+coroutineExceptionHandler).launch {
            withContext(Dispatchers.Main) {
                val response = Repository().getDistrictWiseData(customKey,purpose,status,districtId,tehsilId,ruleTypeId)
                receivedDataResponse.value = response

            }
        }
    }


}