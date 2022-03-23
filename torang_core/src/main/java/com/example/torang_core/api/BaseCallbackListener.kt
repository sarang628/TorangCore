package com.example.torang_core.api

abstract class BaseCallbackListener<V> {
    open fun callback(model: V) {}
    fun failed(msg: String?) {}
    fun apiStart() {}
    fun apiEnd() {}
}