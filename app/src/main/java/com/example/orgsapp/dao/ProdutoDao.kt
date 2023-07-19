package com.example.orgsapp.dao

import com.example.orgsapp.model.Produtos

class ProdutoDao {

    fun add(produto: Produtos){
        produtos.add(produto)
    }

    fun buscaTodos() : List<Produtos>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produtos>()
    }

}