package com.example.memorylist.presenter

import com.example.memorylist.dal.MemoryRepository
import com.example.memorylist.model.Memory
import com.example.memorylist.view.MemoryDisplayActivity
import java.util.*

class MemoryDisplayPresenter (private val view: MemoryDisplayActivity) {
    private var repo: MemoryRepository? = null
    private var memory: Memory? = null

    fun save(){
        memory  = Memory(view.getMemTitle(), Date(),"")
        if(repo==null)
            repo = MemoryRepository(view)
        Thread {
            val res = repo?.addMemory(memory!!)
            view.back()
        }.start()
    }
}