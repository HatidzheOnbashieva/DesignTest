package com.example.designtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.databinding.ItemGenderBinding

class Adapter(): RecyclerView.Adapter<Holder>() {

    var genders: ArrayList<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val viewBinding = ItemGenderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(viewBinding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val genderInfo = genders[position]
        holder.setData(genderInfo)
    }

    override fun getItemCount(): Int {
        return genders.size
    }
}