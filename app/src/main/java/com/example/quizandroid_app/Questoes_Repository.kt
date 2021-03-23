package com.example.quizandroid_app

import com.example.quizandroid_app.model.Gabarito

class Questoes_Repository {
    val perguntas = listOf<Gabarito>(
        Gabarito("Metodo correspondente activity onde" +
                "os dados são insridos para o carregamento de layouts e inicialização de operações que devem ser executadas somente uma vez ", "On Create()", 5),
        Gabarito("Uma Activity:","define em sua estrutura XML o layout da aplicação.\n",10)


    )

    init {
        perguntas.sortedByDescending { g -> g.ponto }
    }
}