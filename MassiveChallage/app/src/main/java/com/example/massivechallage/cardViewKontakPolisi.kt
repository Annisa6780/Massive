package com.example.massivechallage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class cardViewKontakPolisi(private val KontakList: ArrayList<DataKontakPolisi>) : RecyclerView.Adapter<cardViewKontakPolisi.KontakPolisiViewHolder>()  {

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listenerpelapor: onItemClickListener){
        mListener = listenerpelapor
    }

    class KontakPolisiViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder (itemView){
        val tvnama: TextView = itemView.findViewById(R.id.nama_polsek)
        val tvalamat : TextView = itemView.findViewById(R.id.alamat_polsek)
        val tvtelp : TextView = itemView.findViewById(R.id.telp_polsek)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakPolisiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kontak_polisi, parent, false)
        return KontakPolisiViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: KontakPolisiViewHolder, position: Int) {
        val currentItem = KontakList[position]
        holder.tvnama.text = currentItem.nama
        holder.tvalamat.text = currentItem.alamat
        holder.tvtelp.text = currentItem.telp
    }


    override fun getItemCount(): Int {
        return KontakList.size
    }

//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val cardTextView: TextView = view.findViewById(R.id.cv_kontak)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_kontak_polisi, parent, false)
//        return ViewHolder(view)
//    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = dataSet[position]
//        holder.cardTextView.text = item.toString()
//    }
//
//    override fun getItemCount(): Int {
//        return dataSet.size
//    }
}
