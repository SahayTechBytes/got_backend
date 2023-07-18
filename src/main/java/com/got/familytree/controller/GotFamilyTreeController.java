package com.got.familytree.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.got.familytree.dao.CharacterRepository;
import com.got.familytree.dto.CharacterDTO;
import com.got.familytree.exception.CharacterNotFoundException;
import com.got.familytree.model.CharacterEntity;
import com.got.familytree.service.CharacterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/character")
public class GotFamilyTreeController {

	@Autowired
	private CharacterRepository characterRepository;
	
	@Autowired
	private final CharacterService characterService;

    @Autowired
    public GotFamilyTreeController(CharacterService characterService, CharacterRepository characterRepository) {
        this.characterService = characterService;
        this.characterRepository = characterRepository;
    }
	
	@GetMapping
    public String home()
    {
        String str
            = "<html><body><font color=\"green\">"
              + "<h1>WELCOME To Game of Thrones</h1>"
              + "</font></body></html>";
        return str;
    }
	
	@GetMapping("/houses")
    public ResponseEntity<Set<String>> getAllHouses() {
        List<CharacterEntity> characters = characterRepository.findAll();
        Set<String> uniqueHouses = new HashSet<>();

        for (CharacterEntity character : characters) {
            uniqueHouses.addAll(character.getHouseName());
        }

        return ResponseEntity.ok(uniqueHouses);
    }
	
	@GetMapping("/{houseName}")
    public ResponseEntity<List<CharacterEntity>> getCharactersByHouse(@PathVariable String houseName) {
        List<CharacterEntity> characters = characterRepository.findByHouseName(houseName);

        if (characters.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(characters);
        }
    }
	
	@GetMapping("/familytree/{houseName}")
    public ResponseEntity<List<String>> getCharacterNamesByHouse(@PathVariable("houseName") String houseName) {
        List<String> characterNames = characterService.getCharacterNamesByHouse(houseName);
        return new ResponseEntity<>(characterNames, HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/{id}/favourite")
    public ResponseEntity<?> updateFavouriteStatus(@PathVariable("id") Long id) {
        try {
            characterService.updateFavouriteStatus(id);
            return ResponseEntity.ok().build();
        } catch (CharacterNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/favorites")
    public ResponseEntity<List<CharacterDTO>> getFavoriteCharacters() {
        List<CharacterDTO> favoriteCharacters = characterService.getFavouriteCharacters();
        return ResponseEntity.ok(favoriteCharacters);
    }
	
}
