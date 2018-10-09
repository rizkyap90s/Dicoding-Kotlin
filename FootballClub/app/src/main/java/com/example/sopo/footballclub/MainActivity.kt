package com.example.sopo.footballclub

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.startActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Model> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        list_club.layoutManager = LinearLayoutManager(this)
        list_club.adapter = RecyclerViewAdapter(this,items){
            startActivity<SecondActivity>(SecondActivity.POSITIONEXTRA to it)
        }
    }

    fun init(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val des = resources.getStringArray(R.array.deskripsi)
        items.clear()
        for(i in name.indices){
            items.add(Model(name[i], image.getResourceId(i, 0), des[i] ))
        }
        image.recycle()
    }
}