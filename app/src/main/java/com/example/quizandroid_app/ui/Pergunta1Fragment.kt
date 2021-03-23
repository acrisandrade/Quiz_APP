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
import com.example.quizandroid_app.JogadorViewModel
import com.example.quizandroid_app.Questoes_Repository
import com.example.quizandroid_app.QuizViewModel
import com.example.quizandroid_app.R
import com.example.quizandroid_app.model.Gabarito
import kotlinx.android.synthetic.main.fragment_pergunta1.*


class Pergunta1Fragment : Fragment() {

    private val quizViewModel: QuizViewModel by activityViewModels()
    private val jogadorViewModel: JogadorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pergunta1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pergunta_enunciado.text = quizViewModel.ListaQuestoes.value!![0].enunciado
        val questao = quizViewModel.ListaQuestoes.value!![0]
        val l = listOf("OnStart()",questao.respotas, "OnInit", "OnRestart" ,"OnResume")

        for (i in l.indices) {
            val radioButton = RadioButton(context)
            radioButton.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            radioButton.setOnClickListener {view -> click(view as RadioButton, questao)}
            radioButton.text = l[i]
            radioButton.id = i
            radioGroup.addView(radioButton)
        }

//        var button = RadioButton(context)
//        button.setOnClickListener { it -> click (it) }
    }


    fun click (radioButton: RadioButton, questao: Gabarito){
        Toast.makeText(context, "${radioButton.text}", Toast.LENGTH_SHORT).show()
        if (radioButton.text.equals(questao.respotas)) {
            jogadorViewModel.adcionarPontos(questao.ponto)
            Toast.makeText(context, " Mais ${jogadorViewModel.pontuacao.value} ", Toast.LENGTH_SHORT).show()
        }
    }





}