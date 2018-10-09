package com.example.sopo.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model (val name: String?, val image: Int?, val des: String?): Parcelable