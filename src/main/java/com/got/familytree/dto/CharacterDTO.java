package com.got.familytree.dto;

import java.util.List;

public class CharacterDTO {
    
    private String characterName;
    private List<String> houseName;
    private String characterImageThumb;
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public List<String> getHouseName() {
		return houseName;
	}
	public void setHouseName(List<String> houseName) {
		this.houseName = houseName;
	}
	public String getCharacterImageThumb() {
		return characterImageThumb;
	}
	public void setCharacterImageThumb(String characterImageThumb) {
		this.characterImageThumb = characterImageThumb;
	}

    // Getters and setters
}
