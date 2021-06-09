package com.example.myapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.InnerActivity
import com.example.myapplication.R
import com.example.myapplication.api.dto.User
import kotlinx.android.synthetic.main.list.view.*

class UserListAdapter(private val data: List<User>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false))
    }

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
        holder.email.text=data[position].email.toString()
        holder.firstname.text=data[position].firstName.toString()
        holder.lastname.text=data[position].lastName.toString()
        Glide.with(holder.itemView.context).load(data[position].avatar).into(holder.avatar)
        holder.itemView.setOnClickListener{ val intent = Intent(holder.itemView.context, InnerActivity::class.java)
            intent.putExtra("id", data[position].id.toString())
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val avatar = itemView.avatar
        val firstname = itemView.firstname
        val lastname = itemView.lastname
        val email = itemView.email
    }
}