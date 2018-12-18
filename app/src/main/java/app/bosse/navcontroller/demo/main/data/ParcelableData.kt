package app.bosse.navcontroller.demo.main.data

import android.os.Parcel
import android.os.Parcelable

data class ParcelableData(val content: String = "this is content") : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString()!!)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ParcelableData> {
        override fun createFromParcel(parcel: Parcel): ParcelableData {
            return ParcelableData(parcel)
        }

        override fun newArray(size: Int): Array<ParcelableData?> {
            return arrayOfNulls(size)
        }
    }
}