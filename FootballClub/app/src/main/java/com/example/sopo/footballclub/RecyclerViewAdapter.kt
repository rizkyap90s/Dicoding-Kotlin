package com.example.sopo.footballclub

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sopo.footballclub.R.layout.item_list
import kotlinx.android.synthetic.main.activity_main.*
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.abc_activity_chooser_view.view.*
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.coroutines.experimental.NonCancellable
import org.jetbrains.anko.sdk25.coroutines.onClick

class   RecyclerViewAdapter(private val context: Context, private val items:List<Model>, private val listener: (Model)->Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
//        holder.itemView.onClick {
//        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(items: Model, listener: (Model) -> Unit) {
            itemView.idteks.text = items.name
            Glide.with(containerView).load(items.image).into(itemView.idimage)
            containerView.setOnClickListener { listener(items) }
        }
    }
}