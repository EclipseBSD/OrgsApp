package com.example.orgsapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orgsapp.dao.ProdutoDao
import com.example.orgsapp.databinding.ActivityFormularioProdutoBinding
import com.example.orgsapp.model.Produtos
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val saveButton = binding.activityFormularioProdutoBotaoSalvar
        val dao = ProdutoDao()
        saveButton.setOnClickListener {
            val produtoNovo = produtos()
            dao.add(produtoNovo)
            finish()
        }
    }

    private fun produtos(): Produtos {
        val nameForm = binding.activityFormularioProdutoNome
        val descForm = binding.activityFormularioProdutoDescricao
        val valueForm = binding.activityFormularioProdutoValor
        val name = nameForm.text.toString()
        val desc = descForm.text.toString()
        val valueText = valueForm.text.toString()

        val value = if (valueText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valueText)
        }

        return Produtos(
            nome = name,
            descricao = desc,
            preco = value
        )
    }

}
