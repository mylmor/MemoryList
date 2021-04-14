package com.example.memorylist

import com.example.memorylist.model.Memory
import com.example.memorylist.view.MainActivity
import java.util.*
import kotlin.collections.ArrayList

class Presenter(private val view: MainActivity){
    private var memoryList= listOf(
        Memory("Douche",Date(),""),
        Memory("Médoc",Date(),""),
        Memory("Branlette",Date(),""),
        Memory("Manger",Date(),""),
        Memory("Douche",Date(),""),
        Memory("Médoc",Date(),""),
        Memory("Branlette",Date(),""),
        Memory("Manger",Date(),""),
        Memory("Douche",Date(),""),
        Memory("Médoc",Date(),""),
        Memory("Branlette",Date(),""),
        Memory("Manger",Date(),""),
        Memory("Douche",Date(),""),
        Memory("Médoc",Date(),""),
        Memory("Branlette",Date(),""),
        Memory("Manger",Date(),"")
    )
    fun onItemClicked(index :Int){
        view.onItemClicked(memoryList[index])
    }
    fun start(){
        view.initView()
        view.updateView()
    }
    fun getMemories():ArrayList<Memory>{
        return ArrayList(memoryList)
    }

    fun noMemory(): Boolean {
        return memoryList.isEmpty()
    }

    fun update(position: Int) {
        memoryList[position].lasTime = Date()
    }
}