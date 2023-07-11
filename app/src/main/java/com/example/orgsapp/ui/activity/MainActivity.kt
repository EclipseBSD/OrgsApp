package com.example.orgsapp.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsapp.R
import com.example.orgsapp.model.Produtos
import com.example.orgsapp.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val nome = findViewById<TextView>(R.id.nome)
//        nome.text = "Cesta de Frutas"
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Laranja, maçã, melância e cenoura"
//        val preco = findViewById<TextView>(R.id.preco)
//        preco.text = "25.99"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produtos(nome = "Cesta de Frutas", descricao = "Laranja, maçã, melância e cenoura", preco = BigDecimal("25.00")),
            Produtos(nome = "Achocolatado", descricao = "Um belo achocolatado que vai deixar você apaixonado", preco = BigDecimal("15.00")),
            Produtos(nome = "Pão Francês", descricao = "Um pão crocante que faz você ficar louco", preco = BigDecimal("8.00"))
        ))
    }
}