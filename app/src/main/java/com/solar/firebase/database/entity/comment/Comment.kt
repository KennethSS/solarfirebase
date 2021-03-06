package com.solar.firebase.database.entity.comment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comment (
    var id: String = "",
    var name: String = "",
    var text: String = "",
    var date: String = "",
    var img: String? = "",
    var rate: Float = 5.0f
) : Parcelable