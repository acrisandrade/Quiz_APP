package com.example.quizandroid_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private val _ListaQuestoes  = MutableLiveData<List<Gabarito>>()

    val ListaQuestoes : LiveData<List<Gabarito>> = _ListaQuestoes


    fun setQuestoes() {
        _ListaQuestoes.value = Questoes_Repository().perguntas
    }

}