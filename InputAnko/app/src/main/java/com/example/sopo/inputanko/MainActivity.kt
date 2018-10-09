package com.example.sopo.inputanko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

            verticalLayout{
                val input = editText(){
                    hint = "Masukan Namamu Bro!!!"
                }

                button("Toast"){
                    onClick { toast("Halo, ${input.text}") }
                }.lparams(width= matchParent){topMargin=dip(5)}


                button("Alert"){
                    onClick {
                        alert("Selamat ngoding, ${input.text}") {
                            yesButton {
                                toast("Yes")
                            }
                            noButton {  }
                        }.show()
                    }
                }.lparams(width= matchParent){topMargin=dip(5)}


                button("Selector") {
                    onClick {
                        val club = listOf("Barcelona", "Real Madrid", "Bayern Munchen", "Liverpool")
                        selector("Hello, ${input.text}! What's football club do you love?", club) { _, i ->
                            toast("So you love ${club[i]}, right?")
                        }
                    }
                }.lparams(width= matchParent){topMargin=dip(5)}


                button("Snackbar"){
                    onClick {
                        snackbar(input, "Hello, ${input.text}")
                    }
                }.lparams(width= matchParent){topMargin=dip(5)}


                button("Progress Bar"){
                    onClick {
                        indeterminateProgressDialog("Hello, ${input.text}! Please Wait...").show()
                    }
                }.lparams(width= matchParent){topMargin=dip(5)}


                button("Next Activity"){
                    onClick {
                       startActivity<SecondActivity>("name" to "${input.text}")
                    }
                }

            }
        }
    }
}