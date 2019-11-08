package com.ifi.tp.handcraft.controller;

import com.ifi.tp.handcraft.Controller;
import com.ifi.tp.handcraft.RequestMapping;
import com.ifi.tp.handcraft.bo.PokemonType;
import com.ifi.tp.handcraft.repository.PokemonTypeRepository;

import java.util.Map;

@Controller
public class PokemonTypeController {

    private PokemonTypeRepository repository = new PokemonTypeRepository();

    @RequestMapping(uri="/pokemons")
    public PokemonType getPokemon(Map<String,String[]> parameters){
        if(parameters == null){
            throw new IllegalArgumentException("parameters should not be empty");
        }
        if(parameters.containsKey("id")){
            return repository.findPokemonById(Integer.valueOf(parameters.get("id")[0]));
        }
        else if(parameters.containsKey("name")){
            return repository.findPokemonByName(parameters.get("name")[0]);
        }
        throw new IllegalArgumentException("unknown parameter");
    }
}
