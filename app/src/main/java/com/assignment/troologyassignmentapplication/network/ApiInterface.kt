package com.assignment.troologyassignmentapplication.network

import com.assignment.troologyassignmentapplication.model.GetDashboardDataResponse
import com.assignment.troologyassignmentapplication.model.InProcessDataResponse
import com.assignment.troologyassignmentapplication.model.ReceivedDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api/MADashboard")
    suspend fun getMADashboard(@Query("customkey") customkey:String,
                               @Query("districtid") districtid:String,
                               @Query("tehsilid") tehsilid:String
    ): Response<List<GetDashboardDataResponse>>

    @GET("/api/DistrictWiseCount")
    suspend fun getDistrictWiseCount(@Query("customkey") customkey:String,
                                     @Query("purpose") purpose:String,
                                     @Query("status") status:String,
                                     @Query("districtid") districtid:String,
                                     @Query("tehsilid") tehsilid:String,
                                     @Query("ruletypeid") ruletypeid:String,

                                     ): Response<List<ReceivedDataResponse>>

    @GET("/api/InProcessApplicationCount")
    suspend fun getInProcessApplicationCount(@Query("customkey") customkey:String,
                                             @Query("purpose") purpose:String,
                                             @Query("status") status:String,
                                             @Query("districtid") districtid:String,
                                             @Query("tehsilid") tehsilid:String,
                                             @Query("ruletypeid") ruletypeid:String,
                                             @Query("type") type: String
                                             ): Response<List<InProcessDataResponse>>

}