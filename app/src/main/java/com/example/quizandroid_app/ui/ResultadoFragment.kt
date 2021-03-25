package com.example.quizandroid_app.ui

import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.quizandroid_app.JogadorViewModel
import com.example.quizandroid_app.R
import com.example.quizandroid_app.adapter.RankingRecyclerAdapter
import kotlinx.android.synthetic.main.activity_questoes.*
import kotlinx.android.synthetic.main.fragment_resultado.*
import kotlinx.android.synthetic.main.resultado_jogador.*
import java.lang.reflect.Type


class ResultadoFragment : Fragment() {

    private val jogadorViewModel: JogadorViewModel by activityViewModels()
    private lateinit var rankingJogadores: RecyclerView
    private lateinit var ViewModel:JogadorViewModel



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        jogadorViewModel.endGame.value = true
        val view = inflater.inflate(R.layout.fragment_resultado, container, false)
        val adapter = RankingRecyclerAdapter(jogadorViewModel.getRakingOrdenado())
        rankingJogadores = view.findViewById(R.id.lista_resultado_jogador)
        rankingJogadores.adapter = adapter


        return view

    }

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









