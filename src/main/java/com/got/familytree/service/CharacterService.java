package com.got.familytree.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.got.familytree.dao.CharacterRepository;
import com.got.familytree.dto.CharacterDTO;
import com.got.familytree.exception.CharacterNotFoundException;
import com.got.familytree.model.CharacterEntity;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.*;
import java.util.Optional;

@Service
public class CharacterService {

	@Autowired
    private final CharacterRepository characterRepository;
    
    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Transactional
    public void storeCharactersFromJsonFile() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/characters.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            List<CharacterEntity> characters = mapper.readValue(inputStream, new TypeReference<List<CharacterEntity>>() {});
            characterRepository.saveAll(characters);
            System.out.print("File loaded successfully in storeCharactersFromJsonFile");
        } catch (IOException e) {
        	System.out.print("Error in storeCharactersFromJsonFile" + e);
        }catch (Exception e) {
        	System.out.print("Error in storeCharactersFromJsonFile" + e);
        }
    }
    
    public List<String> getCharacterNamesByHouse(String houseName) {
        return characterRepository.findCharacterNamesByHouseName(houseName);
    }
    
    public void updateFavouriteStatus(Long id) {
        Optional<CharacterEntity> characterOptional = characterRepository.findById(id);
        if (characterOptional.isPresent()) {
            CharacterEntity character = characterOptional.get();
            boolean currentFavouriteStatus = character.isFavourite();
            boolean newFavouriteStatus = !currentFavouriteStatus;
            character.setFavourite(newFavouriteStatus);
            characterRepository.save(character);
        } else {
            throw new CharacterNotFoundException(id);
        }
    }
    
    public List<CharacterDTO> getFavouriteCharacters() {
        List<CharacterEntity> favouriteCharacterEntities = characterRepository.findByFavourite(true);
        List<CharacterDTO> favouriteCharacters = new ArrayList<>();

        for (CharacterEntity entity : favouriteCharacterEntities) {
            CharacterDTO character = new CharacterDTO();
            character.setCharacterName(entity.getCharacterName());
            character.setHouseName(entity.getHouseName());
            character.setCharacterImageThumb(entity.getCharacterImageThumb());
            favouriteCharacters.add(character);
        }
        return favouriteCharacters;
    }
}
