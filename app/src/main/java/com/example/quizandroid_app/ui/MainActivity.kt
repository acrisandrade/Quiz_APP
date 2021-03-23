package com.example.quizandroid_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.quizandroid_app.JogadorViewModel
import com.example.quizandroid_app.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //private val jogadorViewModel: JogadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if(editTextTextPersonName.text.toString().isEmpty()){
                Toast.makeText(this, "Insira um NickName", Toast.LENGTH_LONG)
                    .show()
            }else{
                //jogadorViewModel.setarNome(editTextTextPersonName.text.toString())
               // Toast.makeText(this, "${jogadorViewModel.nickname.value}", Toast.LENGTH_SHORT).show()

                val comecar = Intent(this, QuestoesActivity::class.java)
                comecar.putExtra("nickName", editTextTextPersonName.text.toString())
                startActivity(comecar)
//                val params = Bundle()
//                val dados = JogadorViewModel
            }
        }
    }

}