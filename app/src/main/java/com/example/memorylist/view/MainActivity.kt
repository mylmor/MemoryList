package com.example.memorylist.view

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import com.example.memorylist.model.Memory
import com.example.memorylist.Presenter
import com.example.memorylist.R
import com.example.memorylist.view.adapter.MyListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: Presenter
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = Presenter(this)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            onNewItemClicked(view);
        }
        presenter.start()
    }
    fun initView() {
        listView = this.findViewById(R.id.listview)
        listView.adapter = MyListAdapter(this, ArrayList(),nowButtonClicked)
        listView.setOnItemClickListener { _, _, position, _ -> presenter.onItemClicked(position) }
        no_item.text = getString(R.string.loading)
    }
    private val nowButtonClicked = fun(position:Int) {
        presenter.update(position)
        return ToastMaker.makeShortToast(this,"Updated !")
    }

    fun updateView() {
        listView.adapter = MyListAdapter(this, presenter.getMemories(), nowButtonClicked)
        no_item.text = ""
        if (!presenter.noMemory()) no_item.visibility = View.INVISIBLE
        else no_item.visibility = View.VISIBLE
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    private fun onNewItemClicked(e:Any){
        toString()
        // change activity
    }
    fun onItemClicked(item:Memory){
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}