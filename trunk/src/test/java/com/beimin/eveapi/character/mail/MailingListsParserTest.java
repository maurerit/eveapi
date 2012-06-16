package com.beimin.eveapi.character.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.character.mail.lists.ApiMailingList;
import com.beimin.eveapi.character.mail.lists.MailingListsParser;
import com.beimin.eveapi.character.mail.lists.MailingListsResponse;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MailingListsParserTest extends FullAuthParserTest {
	public MailingListsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.MAILING_LISTS);
	}

	@Test
	public void getResponse() throws ApiException {
		MailingListsParser parser = MailingListsParser.getInstance();
		MailingListsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<ApiMailingList> mailinglists = response.getAll();
		assertNotNull(mailinglists);
		assertEquals(3, mailinglists.size());
		boolean found = false;
		for (ApiMailingList mailinglist : mailinglists) {
			if (mailinglist.getListID() == 128250439L) {
				found = true;
				assertEquals("EVETycoonMail", mailinglist.getDisplayName());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}
}