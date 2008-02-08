package com.betterbe.eveapi.skills;

public class Requirement implements Detail {
	private int typeID;
	private String skillLevel;

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	@Override
	public String toString() {
		return "Type: " + typeID + " at level: " + skillLevel;
	}
}
