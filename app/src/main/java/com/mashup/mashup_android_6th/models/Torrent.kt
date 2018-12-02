package com.mashup.mashup_android_6th.models

data class Torrent(
    val url: String,
    val hash: String,
    val quality: String,
    val seeds: Int,
    val peers: Int,
    val size: String,
    val size_bytes: Int,
    val date_uploaded: String,
    val date_uploaded_unix: Int
)