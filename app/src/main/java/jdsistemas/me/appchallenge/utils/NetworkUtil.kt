package jdsistemas.me.appchallenge.utils

import android.content.Context
import android.net.ConnectivityManager


/**
 * Created on data 28/07/18.
 */
open class NetworkUtil {

    var TYPE_WIFI = 1
    var TYPE_MOBILE = 2
    var TYPE_NOT_CONNECTED = 0
    val NETWORK_STATUS_NOT_CONNECTED = 0
    val NETWORK_STAUS_WIFI = 1
    val NETWORK_STATUS_MOBILE = 2

    fun getConnectivityStatus(context: Context): Int {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activityNetwork = cm.activeNetworkInfo
        if (null != activityNetwork) {
            if (activityNetwork.type == ConnectivityManager.TYPE_WIFI) return TYPE_WIFI

            if (activityNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                return TYPE_MOBILE
            }
        }

        return TYPE_NOT_CONNECTED
    }

    fun getConnectivityStatusString(context: Context): Int {
        val conn = getConnectivityStatus(context)
        var status = 0
        if (conn == TYPE_WIFI) {
            status = NETWORK_STAUS_WIFI
        } else if (conn == TYPE_MOBILE) {
            status = NETWORK_STATUS_MOBILE
        } else if (conn == TYPE_NOT_CONNECTED) {
            status = NETWORK_STATUS_NOT_CONNECTED
        }

        return status
    }
}