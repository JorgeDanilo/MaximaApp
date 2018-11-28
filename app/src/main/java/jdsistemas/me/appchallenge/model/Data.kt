package jdsistemas.me.appchallenge.model

import com.google.gson.annotations.SerializedName
import com.orm.SugarRecord
import org.parceler.Parcel
import java.io.Serializable

/**
 * Created on data 27/07/18.
 */
@Parcel(Parcel.Serialization.BEAN)
class Data: SugarRecord(), Serializable {


    @SerializedName("pedidos")
    lateinit var data: List<OrderHistory>
}