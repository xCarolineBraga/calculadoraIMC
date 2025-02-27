package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
       /** ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        val result = intent.getFloatExtra(KEY_RESULT_IMC,0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val classififcacao: String = if (result < 17f){
            "DESNUTRIÇÃO"
        } else if (result > 17f && result <= 18.49f){
            "ABAIXO DO PESO"
        } else if (result > 18.5f && result <= 24.99f){
            "NORMAL"
        } else if (result > 25f && result <= 29.99f){
            "SOBREPESO"
        } else if (result > 30 && result <= 34.99f){
            "OBESIDADE I"
        } else if (result > 35f && result <= 39.99f){
            "OBESIDADE II"
        } else {
            "OBESIDADE MÓRBIDA."
        }
        tvClassificacao.text = classififcacao

        when (classififcacao){
            "DESNUTRIÇÃO" -> tvClassificacao.setTextColor(resources.getColor(R.color.MAGREZA))
            "ABAIXO DO PESO" -> tvClassificacao.setTextColor(resources.getColor(R.color.ABAIXO_DO_PESO))
            "NORMAL" -> tvClassificacao.setTextColor(resources.getColor(R.color.NORMAL))
            "SOBREPESO" -> tvClassificacao.setTextColor(resources.getColor(R.color.SOBREPESO))
            "OBESIDADE I" -> tvClassificacao.setTextColor(resources.getColor(R.color.OBESIDADE_I))
            "OBESIDADE II" -> tvClassificacao.setTextColor(resources.getColor(R.color.OBESIDADE_II))
            "OBESIDADE MÓRBIDA" -> tvClassificacao.setTextColor(resources.getColor(R.color.OBESIDADE_MORBIDA))

        }

    }
}