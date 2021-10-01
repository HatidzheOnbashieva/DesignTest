package com.example.designtest

import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.databinding.ItemGenderBinding

class Holder(private val viewBinding: ItemGenderBinding) : RecyclerView.ViewHolder(viewBinding.root) {
    fun setData(genderInfo: String){
        viewBinding.tvGenderVal.text = genderInfo
    }
}