package com.example.quizandroid_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            if(editTextTextPersonName.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "Insira um NickName", Toast.LENGTH_LONG)
                    .show()
            }else{
                var comecar = Intent(this,Questoes::class.java)
                startActivity(comecar)
            }
        }
    }

}