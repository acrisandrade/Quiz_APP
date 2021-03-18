package com.example.quizandroid_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_pergunta.*


class Pergunta : Fragment() {

    private val quizViewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        quizViewModel.setQuestoes()
        return inflater.inflate(R.layout.fragment_pergunta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pergunta_enunciado.text = quizViewModel.ListaQuestoes.value!![0].enunciado
        var l = listOf("Sou um botão", "Eu tbm sou", "eu sou o mario", "não sei pq estou aqui")
        for (i in 0..3) {
            var radioButton = RadioButton(context)
            radioButton.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            radioButton.text = l[i].toString()
            radioButton.id = i
            radioGroup.addView(radioButton)

        }



    }





}