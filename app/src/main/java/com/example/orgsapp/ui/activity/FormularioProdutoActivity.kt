package com.example.orgsapp.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.orgsapp.R
import com.example.orgsapp.model.Produtos
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_produto)
        val saveButton = findViewById<Button>(R.id.botao_salvar)

        saveButton.setOnClickListener {
            val nameForm: EditText = findViewById(R.id.nome)
            val descForm: EditText = findViewById(R.id.descricao)
            val valueForm: EditText = findViewById(R.id.valor)
            val name = nameForm.text.toString()
            val desc = descForm.text.toString()
            val valueText = valueForm.text.toString()

            val value = if(valueText.isBlank()){
                BigDecimal.ZERO
            } else{
                BigDecimal(valueText)
            }

            val produtoNovo = Produtos(
                nome = name,
                descricao = desc,
                preco = value
            )

            Log.i("C/FormularioProduto", "onCreate: $produtoNovo")

        }


    }


}