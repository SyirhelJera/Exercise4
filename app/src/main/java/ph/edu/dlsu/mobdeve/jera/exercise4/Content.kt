package ph.edu.dlsu.mobdeve.jera.exercise4


import android.os.Parcel
import android.os.Parcelable

class Content (
    val title: String?,
    val creator: Creator,
    val duration: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        Creator(parcel.readString(), parcel.readInt()),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(duration)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Content> {
        override fun createFromParcel(parcel: Parcel): Content {
            return Content(parcel)
        }

        override fun newArray(size: Int): Array<Content?> {
            return arrayOfNulls(size)
        }
    }
}