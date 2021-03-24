package com.example.quizandroid_app.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.quizandroid_app.JogadorViewModel
import com.example.quizandroid_app.R
import com.example.quizandroid_app.adapter.RankingRecyclerAdapter
import com.example.quizandroid_app.model.Jogador
import com.example.quizandroid_app.model.ListaRankingJogadores
import kotlinx.android.synthetic.main.fragment_resultado.*

class ResultadoFragment : Fragment() {

    private val jogadorViewModel: JogadorViewModel by activityViewModels()
    private lateinit var rankingJogadores: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_resultado, container, false)

        val adapter = RankingRecyclerAdapter(jogadorViewModel.getRakingOrdenado())
        rankingJogadores = view.findViewById(R.id.lista_resultado_jogador)
        rankingJogadores.adapter = adapter
        return view
    }


    // TODO: 17/03/2021 Intent Implicita (Compartilhar resultados)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView2.text = "${jogadorViewModel.nickname.value} você obteve total de ${jogadorViewModel.pontuacao.value} pontos"
        imageButton3.setOnClickListener { it -> (compartilhar(it)) }

    }
    fun compartilhar(view: View){
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,  "Obtive total de ${jogadorViewModel.pontuacao.value} pontos no Quiz, venha jogar comigo!")
            type = "text/plain"
        }
        if (sendIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(sendIntent)
        }
    }

}
