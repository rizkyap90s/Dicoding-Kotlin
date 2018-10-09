package com.example.sopo.footballclub

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.select_dialog_item_material.view.*
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val idnama        = 1
        val idimg         = 1
        val iddes         = 1
        val POSITIONEXTRA = "posisi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val listku = intent.getParcelableExtra<Model>(POSITIONEXTRA)

        SecondActivityUI(listku).setContentView(this)
    }
    internal class SecondActivityUI(var listku: Model) : AnkoComponent<SecondActivity> {
        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        override fun createView(ui: AnkoContext<SecondActivity>) = with(ui){
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                imageView{
                    Glide.with(this).load(listku.image).into(this)
                    id = idnama
                    padding = dip(15)

                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(100), dip(100))

                textView{
                    id = idimg
                    text = listku.name
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(15)
                }

                textView{
                    id = iddes
                    text = listku.des
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                    padding = dip(15)
                }

            }
        }

    }
}