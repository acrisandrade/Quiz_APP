package com.example.quizandroid_app

import com.example.quizandroid_app.model.Gabarito

class Questoes_Repository {
    val perguntas = listOf<Gabarito>(
        Gabarito("Alternativa que representa o comando utilizado para a criação de uma activity?", "On Create()", 10),

        Gabarito("Uma Activity:","define em sua estrutura XML o layout da aplicação.\n",17),
        Gabarito("Os aplicativos desenvolvidos para dispositivos móveis como celulares e tablets são denominados:\n","APP\n",10),
        Gabarito("A linguagem de programação considerada como 'nativa' dos ambientes Android é:\n","Java",18),
        Gabarito("Assinale a alternativa correta a respeito dos ciclos de vida da Activity em Android.\n","onStart() só é chamada quando a Activity não estava mais visível e volta a ter o foco.",20),
        Gabarito("qual definição se aplica ao conceito de um Intent","É um objeto responsável pelo repasse de informações para os principais componentes da API do Android",12),
        Gabarito("O componente de aplicativo do Android que fornece uma tela com a qual os usuários podem interagir para fazer algo é: ","Activity", 13)
    )


}