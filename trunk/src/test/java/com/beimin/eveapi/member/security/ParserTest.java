package com.beimin.eveapi.member.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testMemberTrackingParser() throws IOException, SAXException {
		MemberSecurityParser parser = MemberSecurityParser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/MemberSecurity.xml");
		MemberSecurityResponse response = parser.getResponse(input);
		assertNotNull(response);
		Set<ApiSecurityMember> members = response.getMembers();
		assertEquals("Incorrect amount of members found.", 1, members.size());
		ApiSecurityMember member = members.iterator().next();
		assertEquals("Wrong member characterID", 123456789, member.getCharacterID());
		assertEquals("Wrong member name", "Tester", member.getName());
		Set<ApiSecurityRole> roles = member.getRoles();
		assertNotNull(roles);
		assertEquals("Incorrect amount of roles found.", 1, roles.size());
		Set<ApiSecurityTitle> titles = member.getTitles();
		assertNotNull(titles);
		assertEquals("Incorrect amount of titles found.", 3, titles.size());
		int temp = 0;
		for (ApiSecurityTitle securityTitle : titles) {
			long titleID = securityTitle.getTitleID();
			String titleName = securityTitle.getTitleName();
			if(titleID == 1L) {
				assertEquals("Member", titleName);
				temp++;
			} else if(titleID == 512) {
				assertEquals("Gas Attendant", titleName);
				temp++;
			} else if(titleID == 16384) {
				assertEquals("General Manager", titleName);
				temp++;
			}
		}
		assertEquals("Not all titles had the right titleNames.", 3, temp);
	}
}