package jdsistemas.me.appchallenge.model

import com.google.gson.annotations.SerializedName
import com.orm.SugarRecord
import org.parceler.Parcel
import java.io.Serializable


/**
 * Created on data 28/11/18.
 */

@Parcel(Parcel.Serialization.BEAN)
class OrderHistory: SugarRecord(), Serializable {

    @SerializedName("numero_ped_Rca")
    var numero_ped_Rca: String = ""

    @SerializedName("numero_ped_erp")
    var numero_ped_erp: String = ""

    @SerializedName("codigoCliente")
    var codigoCliente: String = ""

    @SerializedName("NOMECLIENTE")
    var nomeCliente: String = ""

    @SerializedName("data")
    var data: String = ""

    @SerializedName("status")
    var status: String = ""


}