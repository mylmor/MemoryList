package com.example.memorylist.dal

import android.content.Context
import android.util.Log
import com.example.memorylist.model.Memory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class MemoryRepository_old(private val context:Context) {
    private fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
    fun updateAsset(memories:List<Memory>,fileName: String): String? {
        val jsonString: String
        try {
           val stream = context.assets.open(fileName)

        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return "jsonString"
    }
    fun getMemories():List<Memory>{
        val jsonFileString = getJsonDataFromAsset("data.json")
        Log.i("data", jsonFileString)

        val gson = Gson()
        val memoryListType = object : TypeToken<List<Memory>>() {}.type

        val memories: List<Memory> = gson.fromJson(jsonFileString, memoryListType)
        memories.forEachIndexed { idx, memory -> Log.i("data", "> Item $idx:\n$memory") }
        return memories
    }
}