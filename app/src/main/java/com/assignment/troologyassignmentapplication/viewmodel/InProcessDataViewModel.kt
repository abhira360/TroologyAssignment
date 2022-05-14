package com.assignment.troologyassignmentapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.troologyassignmentapplication.model.InProcessDataResponse
import com.assignment.troologyassignmentapplication.repository.Repository
import kotlinx.coroutines.*
import java.lang.Exception

class InProcessDataViewModel: ViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throw Exception(throwable.localizedMessage)
    }

    val inProcessDataResponse = MutableLiveData<List<InProcessDataResponse>>()

    fun getInProcessData(customKey: String,
                         purpose: String,
                         status: String,
                         districtId: String,
                         tehsilId: String,
                         ruleTypeId: String,
                         type: String
    ) {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            withContext(Dispatchers.Main) {
                val response = Repository().getInProcessData(customKey,purpose,status,districtId,tehsilId,ruleTypeId,type)
                inProcessDataResponse.value = response
            }
        }
    }

}