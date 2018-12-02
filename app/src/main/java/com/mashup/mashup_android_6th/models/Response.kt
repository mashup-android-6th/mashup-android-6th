package com.mashup.mashup_android_6th.models

data class Response(
    val status: String,
    val status_message: String,
    val data: MoveData
)