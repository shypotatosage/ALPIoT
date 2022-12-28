package com.imtuc.flooddetection.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imtuc.flooddetection.R
import com.imtuc.flooddetection.databinding.SuhuCardBinding
import com.imtuc.flooddetection.model.Suhu

class SuhuAdapter(val listSuhu: ArrayList<Suhu>):
    RecyclerView.Adapter<SuhuAdapter.viewHolder>(){
    class viewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = SuhuCardBinding.bind(itemView)
        fun setData(data: Suhu){
            binding.celcius.text = "Suhu : " + data.celcius + "°C"
            binding.time.text = data.datetime
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.suhu_card, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: SuhuAdapter.viewHolder, position: Int) {
        holder.setData(listSuhu[position])
    }

    override fun getItemCount(): Int {
        return listSuhu.size
    }

}