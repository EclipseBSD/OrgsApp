package com.example.orgsapp.dao

import com.example.orgsapp.model.Produtos
import java.math.BigDecimal

class ProdutoDao {

    fun add(produto: Produtos) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produtos> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produtos>(
            Produtos(
                nome = "Salada de Frutas",
                descricao = "Maçãs, Laranjas e diversas frutas",
                preco = BigDecimal("19.99")
            )
        )
    }

}