package com.dicoding.mountainlistapps
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mountain(
    var photo: Int,
    var name: String,
    var desc: String,
    var geography: String,
    var peakHeight: String,
    var mountainType: String,
    var lowestTemperature: String,
    var climbingDuration: String,
    var myth: String,
    var description: String
) : Parcelable