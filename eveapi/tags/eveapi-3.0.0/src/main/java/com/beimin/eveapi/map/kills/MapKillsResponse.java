package com.beimin.eveapi.map.kills;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.core.ApiResponse;

public class MapKillsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Map<Integer, Integer> shipKills = new HashMap<Integer, Integer>();
	private final Map<Integer, Integer> factionKills = new HashMap<Integer, Integer>();
	private final Map<Integer, Integer> podKills = new HashMap<Integer, Integer>();

	public void addSystemKills(ApiSystemKills systemKills) {
		shipKills.put(systemKills.getSolarSystemID(),
				systemKills.getShipKills());
		factionKills.put(systemKills.getSolarSystemID(),
				systemKills.getFactionKills());
		podKills.put(systemKills.getSolarSystemID(), systemKills.getPodKills());
	}

	public Map<Integer, Integer> getShipKills() {
		return shipKills;
	}

	public Map<Integer, Integer> getFactionKills() {
		return factionKills;
	}

	public Map<Integer, Integer> getPodKills() {
		return podKills;
	}
}
