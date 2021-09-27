package com.josivaniomarinho.pokemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Define o construtor que recebea lista de pokemons e o click
class PokemonAdapter(
    val pokemons: List<Pokemon>,
    val onClick: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    // ViewHolder com as Views
    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Views do layout (adapter_pokemon)
        var txtNome = view.findViewById<TextView>(R.id.txtNome)
        var txtTipo = view.findViewById<TextView>(R.id.txtTipo)
        var txtNumero = view.findViewById<TextView>(R.id.txtNumero)
        var img = view.findViewById<ImageView>(R.id.imgPokemon)
    }

    // Infla o layout do adapter e retora o ViewHolder. Em outras palavras cria cada item vizual na tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    // Faz o bind para atualizar as views com os dados do Pokemon
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        // Recupera o objeto Pokemon
        var p = pokemons[position]

        // Atualiza os dados
        holder.txtNome.text = p.nome
        holder.txtTipo.text = p.tipo
        holder.txtNumero.text = p.numero
        holder.img.setImageResource(p.img)

        // Evento de clique
        holder.itemView.setOnClickListener { onClick(p) }
    }

    // Retorna a quantidade de cards que precisam ser criados
    override fun getItemCount(): Int = pokemons.size
}