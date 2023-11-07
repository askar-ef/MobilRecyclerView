package com.example.mobilrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilrecyclerview.databinding.ListItemBinding
class MyAdapter(private val mobilList: ArrayList<Mobil>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    inner class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position)
                }
            }
        }

        fun bind(currentItem: Mobil) {
            binding.titleImage.setImageResource(currentItem.titleImage)
            binding.tvHeading.text = currentItem.heading
            binding.tvIntro.text = currentItem.intro.substringBefore(".") + "."
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mobilList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = mobilList[position]
        holder.bind(currentItem)
    }
}
