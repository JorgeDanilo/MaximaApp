package jdsistemas.me.appchallenge.model

import com.google.gson.annotations.SerializedName
import com.orm.SugarRecord
import org.parceler.Parcel
import java.io.Serializable

/**
 * Created on data 27/07/18.
 */

@Parcel(Parcel.Serialization.BEAN)
class Article: SugarRecord(), Serializable {

    @SerializedName("title")
    var title: String = ""

    @SerializedName("website")
    var website: String = ""

    @SerializedName("authors")
    var authors: String = ""

    @SerializedName("date")
    var date: String = ""

    @SerializedName("content")
    var content: String = ""

    @SerializedName("image_url")
    var image_url: String = ""

    var isRead: Boolean = false
}