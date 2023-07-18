package com.got.familytree.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.got.familytree.model.CharacterEntity;


public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {

	List<CharacterEntity> findByHouseName(String houseName);
	
	default List<String> findCharacterNamesByHouseName(String houseName) {
        List<CharacterEntity> characterEntities = findByHouseName(houseName);
        return characterEntities.stream()
                .map(CharacterEntity::getCharacterName)
                .collect(Collectors.toList());
    }
	
	 List<CharacterEntity> findByFavourite(boolean favorite);
}
