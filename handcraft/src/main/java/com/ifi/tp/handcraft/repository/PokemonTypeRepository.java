package com.ifi.tp.handcraft.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.tp.handcraft.bo.PokemonType;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepository() {
        try {
            var pokemonsStream = this.getClass().getResourceAsStream("/pokemons.json");

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PokemonType findPokemonById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);

        return this.pokemons.stream().filter(it -> it.getId() == id).findAny().orElseThrow();
    }

    public PokemonType findPokemonByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);

        return this.pokemons.stream().filter(it -> it.getName().equals(name)).findAny().orElseThrow();
    }

    public List<PokemonType> findAllPokemon() {
        return this.pokemons.stream().sorted((o1, o2) -> o2.getId() - o1.getId()).collect(Collectors.toList());
    }
}
