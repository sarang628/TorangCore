package com.example.torang_core.data.model

import com.google.gson.GsonBuilder

open class BaseDataModel {
    override fun toString(): String {
        return gson.toJson(this)
    }

    companion object {
        var gson = GsonBuilder().setPrettyPrinting().create()
    }
}