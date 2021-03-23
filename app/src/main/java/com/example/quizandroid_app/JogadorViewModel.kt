package com.example.quizandroid_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizandroid_app.model.ListaJogadores

class JogadorViewModel : ViewModel() {
    private val _nickname = MutableLiveData<String>()
    var pontuacao = MutableLiveData<Int>()

    init {
        pontuacao.value = 0
    }

    val nickname : LiveData<String>
    get() = _nickname

    fun setarNome(nome: String) {
        _nickname.value = nome
    }

    fun adcionarPontos(pontos: Int) {
        pontuacao.value =  pontuacao.value?.plus(pontos)
    }

}