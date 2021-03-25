package com.example.quizandroid_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizandroid_app.model.Gabarito

class QuizViewModel : ViewModel() {
    private val _ListaQuestoes  = MutableLiveData(Questoes_Repository().perguntas)

    val ListaQuestoes : LiveData<List<Gabarito>>
    get() = _ListaQuestoes
    }