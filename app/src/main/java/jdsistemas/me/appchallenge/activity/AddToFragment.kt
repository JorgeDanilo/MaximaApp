package jdsistemas.me.appchallenge.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity


/**
 * Add fragment on activity.
 */
fun AppCompatActivity.addFragmentTo(containerId: Int, fragment: Fragment, tag: String = "") {
    supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()
}