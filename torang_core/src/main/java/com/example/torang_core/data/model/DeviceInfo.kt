package com.example.torang_core.data.model

open class DeviceInfo constructor(
    val uuid: String,
    val model: String,
    val version: Int,
    val serial: String,
    val timeZone: String,
    val langauge: String
)