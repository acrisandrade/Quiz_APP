package com.example.quizandroid_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels

class Questoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questoes)
        //val vm: QuizViewModel by viewModels()
        //vm.setQuestoes()
        //Log.i("Demo", "${vm.ListaQuestoes.value!!.size}")
    }
}