package com.beimin.eveapi.eve.character;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.ApiResponse;

public class CharacterLookupResponse extends ApiResponse {
	private final Collection<ApiCharacterLookup> characters = new HashSet<ApiCharacterLookup>();

	public Collection<ApiCharacterLookup> getCharacterLookups() {
		return characters;
	}
	
	
	public void addCharacterLookup(ApiCharacterLookup lookup){
		characters.add(lookup);
	}
}