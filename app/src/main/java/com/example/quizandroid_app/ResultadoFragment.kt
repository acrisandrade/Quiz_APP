package com.example.quizandroid_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ResultadoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultado, container, false)
    }

    //val sendIntent = Intent().apply {
    //                    action = Intent.ACTION_SEND
    //                    putExtra(Intent.EXTRA_TEXT, "aqui eu coloquei a msg")
    //                    type = "text/plain"
    //                }
    // TODO: 17/03/2021 Intent Implicita (Compartilhar resultados)

}