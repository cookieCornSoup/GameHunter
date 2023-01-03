package com.example.gamehunter.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamehunter.R

class CustomAdapter(private val arrayList: ArrayList<User>, private val context: Context) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: CustomViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(arrayList[position].profile)
            .into(holder.GH_profile)
        holder.GH_id.text = arrayList[position].id
        holder.GH_pw.text = arrayList[position].pw.toString()
        holder.GH_userName.text = arrayList[position].userName
    }

    override fun getItemCount(): Int {
        // ternary operator
        return arrayList.size
    }

    inner class CustomViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var GH_profile: ImageView
        var GH_id: TextView
        var GH_pw: TextView
        var GH_userName: TextView

        init {
            GH_profile = itemView.findViewById(R.id.GH_profile)
            GH_id = itemView.findViewById(R.id.GH_id)
            GH_pw = itemView.findViewById(R.id.GH_pw)
            GH_userName = itemView.findViewById(R.id.GH_userName)
        }
    }
}
