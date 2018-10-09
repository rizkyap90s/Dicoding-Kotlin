package com.example.sopo.anko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.style
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

    }

    class MainActivityUI : AnkoComponent<MainActivity> {
            override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

                verticalLayout{
                    imageView(R.drawable.dicoding).lparams(width= matchParent){
                        padding = dip(15)
                        margin = dip(15)
                    }
                    val name = editText(){
                        hint = "Siapa Namammu ?"
                    }
                    button("Hallo!!!"){
                        onClick { toast("Hello, ${name.text}") }
                    }

                }
            }
    }
}
