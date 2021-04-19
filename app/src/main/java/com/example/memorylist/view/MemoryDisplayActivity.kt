package com.example.memorylist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.memorylist.R
import com.example.memorylist.model.DateFormater
import com.example.memorylist.model.Memory
import com.example.memorylist.presenter.MemoryDisplayPresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_memory_display.*
import java.lang.Exception

class MemoryDisplayActivity : AppCompatActivity() {
    private val presenter = MemoryDisplayPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_display)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {presenter.save()}
        retrieveMemory()
    }
    private fun retrieveMemory(){
        memory_picture.setImageResource(R.drawable.ic_launcher_foreground)
        if (intent.extras == null)
            return
        val mem = intent.getSerializableExtra(getString(R.string.memory_extra)) as Memory
        memory_title.setText(mem.name)
        memory_lastDate.setText(DateFormater.fullDate(mem.lasTime))
    }
    fun back(){
        ToastMaker.makeShortToast(this,"Ok !")
        startActivity(Intent(this, MainActivity::class.java))
    }
    fun getMemTitle():String{
        return memory_title.text.toString()
    }
    fun getMemLastDate():String{
        return  memory_lastDate.text.toString()
    }
}