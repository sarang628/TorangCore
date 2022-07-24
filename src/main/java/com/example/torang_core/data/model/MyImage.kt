package com.example.torang_core.data.model

import android.os.Parcel
import android.os.Parcelable
import com.example.torang_core.data.model.BaseDataModel

class MyImage : BaseDataModel, Parcelable {
    var data: String? = null

    constructor() {}
    protected constructor(`in`: Parcel) {
        data = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(data)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(obj: Any?): Boolean {
        var compare = false
        if (obj != null && obj is MyImage) {
            compare = data == obj.data
        }
        return compare
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MyImage> = object : Parcelable.Creator<MyImage> {
            override fun createFromParcel(`in`: Parcel): MyImage {
                return MyImage(`in`)
            }

            override fun newArray(size: Int): Array<MyImage?> {
                return arrayOfNulls(size)
            }
        }
    }
}