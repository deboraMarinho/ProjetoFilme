package com.example.debce.projetofilme.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.debce.projetofilme.R
import com.example.debce.projetofilme.model.Filme
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_lista_filme.view.*

class FilmeRecyclerAdapter internal constructor(context: Context) :
        RecyclerView.Adapter<FilmeRecyclerAdapter.ViewHolder>() {

    var onItemClick: ((Filme) -> Unit)? = null
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var filmes  = emptyList<Filme>() // Cached copy of friends
    //  private val mContext = context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoFilme: CircleImageView = itemView.imgFilmeListaFoto
        val nomeFilme: TextView = itemView.txtFilmeListaNome
        val cardView: CardView = itemView.cardFilme

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(filmes[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(holder: ViewGroup, position: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_lista_filme, holder, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = filmes[position]
        holder.nomeFilme.text = current.fNome
        // it.photoFriend.text = friend.fSrcPhoto

        /* holder.itemView.setOnClickListener {v->
             val intent = Intent(v.context, NewFriendActivity::class.java)
             intent.putExtra("goFriend", current)
             v.context.startActivity(intent)
         }
         */

    }

    override fun getItemCount() = filmes.size

    fun setFilmeList(filmeList: List<Filme>){
        this.filmes = filmeList
        notifyDataSetChanged()
    }

}