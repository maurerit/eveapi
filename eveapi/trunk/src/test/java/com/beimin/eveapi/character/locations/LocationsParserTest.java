package com.beimin.eveapi.character.locations;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.locations.AbstractLocationsParser;
import com.beimin.eveapi.shared.locations.ApiLocation;
import com.beimin.eveapi.shared.locations.LocationsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class LocationsParserTest extends FullAuthParserTest {
	public LocationsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.LOCATIONS);
	}

	@Test
	public void getResponse() throws ApiException {
		AbstractLocationsParser parser = LocationsParser.getInstance();
		LocationsResponse response = parser.getResponse(auth, Arrays.asList(1002861698719L));
		assertNotNull(response);
		Collection<ApiLocation> locations = response.getAll();
		assertNotNull(locations);
		assertEquals(1, locations.size());
		ApiLocation location = locations.iterator().next();
		assertEquals(1002861698719L, location.getItemID());
		assertEquals("Caldari Control Tower Medium", location.getItemName());
		assertEquals(-896690626560L, location.getX());
		assertEquals(-163314032640L, location.getY());
		assertEquals(-1323431485440L, location.getZ());
	}
}