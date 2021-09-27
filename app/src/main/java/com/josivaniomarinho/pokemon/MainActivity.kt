package com.josivaniomarinho.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var pokemons = listOf<Pokemon>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referência do RecyclerView no nosso layout
        recyclerView = findViewById(R.id.recyclerView)

        // Configura o RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskPokemons()
    }

    private fun taskPokemons() {
        // Busca os Pokemons
        this.pokemons = PokemonService.getPokemons()
        // Atualiza a lista
        recyclerView.adapter = PokemonAdapter(pokemons) { onClickPokemon(it) }
    }

    // Trata o evento de clique no Pokemon
    private fun onClickPokemon(pokemon: Pokemon) {
        Toast.makeText(applicationContext, "Clicou no ${pokemon.nome}", Toast.LENGTH_SHORT).show()
    }
}