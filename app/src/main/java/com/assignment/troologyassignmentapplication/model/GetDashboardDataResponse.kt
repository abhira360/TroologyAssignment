package com.assignment.troologyassignmentapplication.model

data class GetDashboardDataResponse(
    val PurposeType:String,
    val RECEIVED:String,
    val APPROVED:String,
    val REJECTED:String,
    val INPROCESS:String,
    val PurposeId:String,
    val RuleTypeId:String
)
