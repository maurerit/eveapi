package com.beimin.eveapi.map.factwar.systems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class FacWarSystemsParserTest extends NoAuthParserTest {
	public FacWarSystemsParserTest() {
		super(ApiPath.MAP, ApiPage.FACTION_WAR_SYSTEMS);
	}

	@Test
	public void getResponse() throws ApiException {
		FacWarSystemsParser parser = FacWarSystemsParser.getInstance();
		FacWarSystemsResponse response = parser.getResponse();
		Set<ApiFacWarSystem> systems = response.getAll();
		assertEquals(171, systems.size());
		Iterator<ApiFacWarSystem> iterator = systems.iterator();
		ApiFacWarSystem facWarSystem = iterator.next();
		assertEquals(30002057, facWarSystem.getSolarSystemID());
		assertEquals("Hadozeko", facWarSystem.getSolarSystemName());
		assertEquals(0, facWarSystem.getOccupyingFactionID());
		assertEquals("", facWarSystem.getOccupyingFactionName());
		assertFalse("This system shouldn't be contested.", facWarSystem.isContested());
		for (int i = 0; i < 92; i++)
			iterator.next();
		facWarSystem = iterator.next();
		assertEquals(30045344, facWarSystem.getSolarSystemID());
		assertEquals("Nennamaila", facWarSystem.getSolarSystemName());
		assertEquals(500001, facWarSystem.getOccupyingFactionID());
		assertEquals("Caldari State", facWarSystem.getOccupyingFactionName());
		assertTrue("This system shouldn't be contested.", facWarSystem.isContested());
	}
}