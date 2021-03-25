package com.example.quizandroid_app.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.quizandroid_app.JogadorViewModel
import com.example.quizandroid_app.R
import kotlinx.android.synthetic.main.activity_questoes.*

class QuestoesActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val jogadorViewModel: JogadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questoes)

        jogadorViewModel.pontuacao.observe(this, Observer { pontuacao ->
            textView5.text = pontuacao.toString()
        })

        jogadorViewModel.endGame.observe(this, Observer {
            if (it)
                textView5.visibility = View.INVISIBLE
        })




        val nomeJogador = intent.getStringExtra("nickName")
        jogadorViewModel.setarNome(nomeJogador!!)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        Activity.RESULT_OK
    }
}