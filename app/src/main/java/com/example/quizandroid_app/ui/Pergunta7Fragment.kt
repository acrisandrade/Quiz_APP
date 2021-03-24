package com.example.quizandroid_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizandroid_app.JogadorViewModel
import com.example.quizandroid_app.QuizViewModel
import com.example.quizandroid_app.R
import com.example.quizandroid_app.model.Gabarito
import kotlinx.android.synthetic.main.fragment_pergunta1.*


class Pergunta7Fragment : Fragment() {
    private val quizViewModel: QuizViewModel by activityViewModels()
    private val jogadorViewModel: JogadorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pergunta7, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pergunta_enunciado.text = quizViewModel.ListaQuestoes.value!![6].enunciado
        val perguntas = quizViewModel.ListaQuestoes.value!![6]
        val q = listOf(perguntas.respotas,"BroadcastReceiver","ContentProvider","Intent")

        for (i in q.indices){
            val radioButton = RadioButton(context)
            radioButton.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            radioButton.setOnClickListener {view -> correta(view as RadioButton, perguntas)}
            radioButton.text = q[i]
            radioButton.textSize = 15F
            radioButton.id = i
            radioGroup.addView(radioButton)
        }
    }
    fun correta (radioButton: RadioButton, pergunta: Gabarito){
        Toast.makeText(context,"${radioButton.text}", Toast.LENGTH_SHORT).show()
        if (radioButton.text.equals(pergunta.respotas)){
            jogadorViewModel.adcionarPontos(pergunta.ponto)
            Toast.makeText(context, " Mais ${pergunta.ponto} pontos", Toast.LENGTH_SHORT).show()
        }
        findNavController().navigate(R.id.action_pergunta7Fragment_to_resultadoFragment)
    }


}