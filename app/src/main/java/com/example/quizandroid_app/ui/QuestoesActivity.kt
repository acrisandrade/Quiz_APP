package com.example.quizandroid_app.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.quizandroid_app.JogadorViewModel
import com.example.quizandroid_app.R

class QuestoesActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val jogadorViewModel: JogadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questoes)
        //val vm: QuizViewModel by viewModels()
        //vm.setQuestoes()
        //Log.i("Demo", "${vm.ListaQuestoes.value!!.size}")
        val nomeJogador = intent.getStringExtra("nickName")
        jogadorViewModel.setarNome(nomeJogador!!)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        Activity.RESULT_OK
        Log.i("asdf", "VEIO ${jogadorViewModel.nickname.value}")
    }
}