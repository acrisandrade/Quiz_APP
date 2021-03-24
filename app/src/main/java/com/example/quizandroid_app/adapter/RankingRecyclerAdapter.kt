package com.example.quizandroid_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizandroid_app.R
import com.example.quizandroid_app.model.Jogador

class RankingRecyclerAdapter(
    private val jogadores: List<Jogador>
): RecyclerView.Adapter<RankingRecyclerAdapter.JogadorViewHolder>() {

    class JogadorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNomeJogador : TextView = view.findViewById(R.id.jogador_nome)
        val textViewPontosJogador : TextView = view.findViewById(R.id.jogador_pontos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogadorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.resultado_jogador, parent, false)
        return JogadorViewHolder(view)
    }

    override fun onBindViewHolder(holder: JogadorViewHolder, position: Int) {
        val jogador = jogadores[position]
        holder.textViewNomeJogador.text = jogador.nome
        holder.textViewPontosJogador.text = jogador.pontos.toString()
    }

    override fun getItemCount(): Int {
        return jogadores.size
    }

}