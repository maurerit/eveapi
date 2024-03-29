package com.beimin.eveapi.eve.skilltree;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.ApiResponse;

public class SkillTreeResponse extends ApiResponse {
	private final Collection<ApiSkillGroup> skillGroups = new HashSet<ApiSkillGroup>();

	public void addSkillGroup(ApiSkillGroup skillGroup) {
		skillGroups.add(skillGroup);
	}

	public Collection<ApiSkillGroup> getSkillGroups() {
		return skillGroups;
	}

	@Override
	public String toString() {
		String result = "";
		for (ApiSkillGroup skillGroup : skillGroups) {
			result += skillGroup + "\n";
		}
		return result;
	}
}
