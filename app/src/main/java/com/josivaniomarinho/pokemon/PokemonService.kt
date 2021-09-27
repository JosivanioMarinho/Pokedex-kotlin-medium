package com.josivaniomarinho.pokemon

object PokemonService {

    fun getPokemons(): List<Pokemon> {
        // Cria uma lista vazia
        val pokemons = mutableListOf<Pokemon>()

        // cria 20 Pokémons e adiciona na lista
        for(i in 1..20){
            val pokemon = Pokemon()
            pokemon.nome = "Pokémon $i"
            pokemon.tipo = "Tipo $i"
            pokemon.numero = "N° $i"
            pokemon.img = R.drawable.pokeball

            pokemons.add(pokemon)
        }
        return pokemons
    }
}