package com.example.memorylist.presenter

import com.example.memorylist.dal.MemoryRepository
import com.example.memorylist.model.Memory
import com.example.memorylist.view.MainActivity
import java.util.*
import kotlin.collections.ArrayList

class MemoryListPresenter(private val view: MainActivity){
    private var repo : MemoryRepository? = null
    private var memoryList=  listOf<Memory>()
      /*  listOf(
        Memory("Douche",Date(),""),
        Memory("Médoc",Date(),""),
        Memory("Branlette",Date(),""),
        Memory("Manger",Date(),""),
        Memory("Douche1",Date(),""),
        Memory("Médoc1",Date(),""),
        Memory("Branlette1",Date(),""),
        Memory("Manger1",Date(),""),
        Memory("Douche2",Date(),""),
        Memory("Médoc2",Date(),""),
        Memory("Branlette2",Date(),""),
        Memory("Manger2",Date(),""),
        Memory("Douche3",Date(),""),
        Memory("Médoc3",Date(),""),
        Memory("Branlette3",Date(),""),
        Memory("Manger3",Date(),"")
    )*/
    fun onItemClicked(index :Int){
        view.onItemClicked(memoryList[index])
    }
    fun start(){
        view.initView()
        initDb()
        view.updateView()
    }
    fun getMemories():ArrayList<Memory>{
        return ArrayList(memoryList)
    }
    fun initDb(){
        if(repo==null)
            repo = MemoryRepository(view)
        Thread{
            memoryList = repo!!.getAllMemories()
            view.runOnUiThread{
                view.updateView()
            }
        }.start()
    }
    fun addMemory(memory:Memory){
        Thread{
            if(repo==null)
                repo = MemoryRepository(view)
            var res = repo!!.addMemory(memory)
        }.start()
    }
    fun noMemory(): Boolean {
        return memoryList.isEmpty()
    }

    fun update(position: Int) {
        memoryList[position].lasTime = Date()
    }
}