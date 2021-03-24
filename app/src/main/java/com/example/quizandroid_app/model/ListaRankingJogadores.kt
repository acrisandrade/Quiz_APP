package com.example.quizandroid_app.model

class ListaRankingJogadores {

    val ranking = mutableListOf<Jogador>(
        Jogador("Joaozinho das Neves", 33),
        Jogador("Daniele dos dragões", 70),
        Jogador("Maneta", 15),
        Jogador("Zé pequeno", 100)
    )//.sortedByDescending { jogador -> jogador.pontos }


}