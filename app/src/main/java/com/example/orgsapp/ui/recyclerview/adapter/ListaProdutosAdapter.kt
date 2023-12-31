package com.example.orgsapp.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.orgsapp.databinding.ProdutoItemBinding
import com.example.orgsapp.model.Produtos
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produtos>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val nome = binding.produtoItemNome
        private val descricao = binding.produtoItemDescricao
        private val preco = binding.produtoItemPreco
        fun vincula(produto: Produtos) {
            nome.text = produto.nome
            descricao.text = produto.descricao
            val formataMoeda: String = formatarMoedaBrasil(produto.preco)
            preco.text = formataMoeda
            binding.imageView.load(produto.imagem)
        }

        private fun formatarMoedaBrasil(valor: BigDecimal): String{
            val formatoMoeda: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return formatoMoeda.format(valor)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = produtos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    fun atualiza(produtos: List<Produtos>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
