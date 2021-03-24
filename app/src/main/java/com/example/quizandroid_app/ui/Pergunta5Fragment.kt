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


class Pergunta5Fragment : Fragment() {
    private val quizViewModel: QuizViewModel by activityViewModels()
    private val jogadorViewModel: JogadorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pergunta5, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pergunta_enunciado.text = quizViewModel.ListaQuestoes.value!![4].enunciado
        val perguntas = quizViewModel.ListaQuestoes.value!![4]
        val q = listOf("onRestart() é quando uma Activity que estava em background volta a ter foco" +
                "onResume() é a primeira função a ser invocada quando a Activity perde o foco."," onStop() é a última função a ser executada, ou seja, não pode mais ser relançada" +
                "onDestroy() só é chamada quando a Activity fica completamente encoberta por outra Activity",perguntas.respotas)

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
            Toast.makeText(context, " Mais ${pergunta.ponto}  Pontos", Toast.LENGTH_SHORT).show()
        }
        findNavController().navigate(R.id.action_pergunta5Fragment_to_pergunta6Fragment)

    }


}