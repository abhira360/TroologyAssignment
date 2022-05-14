package com.assignment.troologyassignmentapplication.repository

import com.assignment.troologyassignmentapplication.model.GetDashboardDataResponse
import com.assignment.troologyassignmentapplication.model.InProcessDataResponse
import com.assignment.troologyassignmentapplication.model.ReceivedDataResponse
import com.assignment.troologyassignmentapplication.network.ApiClient
import com.assignment.troologyassignmentapplication.network.ApiInterface
import java.lang.Exception

class Repository {

    suspend fun getMADashboard(customKey: String,
                               districtId: String,
                               tehsilId: String
    ): List<GetDashboardDataResponse> {
        ApiClient.getApiService<ApiInterface>().getMADashboard(customKey,districtId,tehsilId).let {
            return if (it.isSuccessful) {
                it.body()!!
            }
            else {
                throw Exception("Failed in getting MADashboard Count")
            }
        }
    }

    suspend fun getDistrictWiseData(customKey: String,
                                    purpose: String,
                                    status: String,
                               districtId: String,
                               tehsilId: String,
                                    ruleTypeId: String

    ): List<ReceivedDataResponse> {
        ApiClient.getApiService<ApiInterface>().getDistrictWiseCount(customKey,
            purpose,
            status,
            districtId,
            tehsilId,
            ruleTypeId
        ).let {
            return if (it.isSuccessful) {
                it.body()!!
            }
            else {
                throw Exception("Failed in getting MADashboard Count")
            }
        }
    }

    suspend fun getInProcessData(customKey: String,
                                    purpose: String,
                                    status: String,
                                    districtId: String,
                                    tehsilId: String,
                                    ruleTypeId: String,
                                 type: String

    ): List<InProcessDataResponse> {
        ApiClient.getApiService<ApiInterface>().getInProcessApplicationCount(customKey,
            purpose,
            status,
            districtId,
            tehsilId,
            ruleTypeId,
            type
        ).let {
            return if (it.isSuccessful) {
                it.body()!!
            }
            else {
                throw Exception("Failed in getting MADashboard Count")
            }
        }
    }


}