package com.example.memorylist.view

import android.content.Context
import android.widget.Toast
import org.jetbrains.anko.runOnUiThread

object ToastMaker {
    fun makeLongToast(context: Context, message: String)=
        makeToast(
            context,
            message,
            Toast.LENGTH_LONG
        )

    fun makeShortToast(context: Context, message: String) =
        makeToast(
            context,
            message,
            Toast.LENGTH_SHORT
        )

    private fun makeToast(context: Context, message: String, length: Int) =
        context.runOnUiThread { Toast.makeText(context, message, length).show()}

}