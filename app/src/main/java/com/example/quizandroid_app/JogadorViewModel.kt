package com.example.quizandroid_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizandroid_app.model.Jogador
import com.example.quizandroid_app.model.ListaRankingJogadores

class JogadorViewModel : ViewModel() {
    var endGame=  MutableLiveData(false)
    private val _nickname = MutableLiveData<String>()
    private val _ranking = MutableLiveData(ListaRankingJogadores().ranking)
    var pontuacao = MutableLiveData<Int>()

    init {
        pontuacao.value = 0

    }

    fun getRakingOrdenado(): List<Jogador> {
        try {
            _ranking.value!!.add(Jogador(_nickname.value.toString(), pontuacao.value!!.toInt()))
        } catch(e: Exception) {
            return mutableListOf(Jogador("Não foi possível recuperar o ranking", 0))
        }
        return _ranking.value!!.sortedByDescending { jogador -> jogador.pontos }
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