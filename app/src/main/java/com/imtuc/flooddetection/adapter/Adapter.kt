package com.imtuc.flooddetection.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imtuc.flooddetection.R
import com.imtuc.flooddetection.databinding.HuluCardBinding
import com.imtuc.flooddetection.model.HuluHilir

class Adapter(val listHuluHilir: ArrayList<HuluHilir>):
    RecyclerView.Adapter<Adapter.viewHolder>(){
    class viewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    val binding = HuluCardBinding.bind(itemView)
        fun setData(data: HuluHilir){
            binding.distance.text = "Jarak : " + data.distance
            binding.time.text = data.datetime

            if (data.distance.toDouble() < 100) {
                binding.distance.setTextColor(Color.RED)
                binding.time.setTextColor(Color.RED)
            } else if (data.distance.toDouble() < 150){
                binding.distance.setTextColor(Color.parseColor("#BE901B"))
                binding.time.setTextColor(Color.parseColor("#BE901B"))
            } else {
                binding.distance.setTextColor(Color.parseColor("#31881E"))
                binding.time.setTextColor(Color.parseColor("#31881E"))
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.hulu_card, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.setData(listHuluHilir[position])
    }

    override fun getItemCount(): Int {
        return listHuluHilir.size
    }

}