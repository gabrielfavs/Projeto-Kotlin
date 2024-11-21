package com.example.projeto.mainactivity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto.R

class ClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)  // Associa o layout XML à Activity

        val btnVoltar = findViewById<Button>(R.id.btn_voltar)

        btnVoltar.setOnClickListener {
            finish() // Encerra a atividade atual e volta à anterior
        }
    }
}
