package com.betterbe.eveapi.skills;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.betterbe.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser {

	private static final String APIURL = "http://api.eve-online.com/eve/SkillTree.xml.aspx";

	private Digester getDigester() {
		Digester digester = super.getDigester(Response.class);
		digester.addObjectCreate("eveapi/result/rowset/row", SkillGroup.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSkillGroup");
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", Skill.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addBeanPropertySetter("eveapi/result/rowset/row/rowset/row/description");
		digester.addBeanPropertySetter("eveapi/result/rowset/row/rowset/row/rank");
		digester.addFactoryCreate("eveapi/result/rowset/row/rowset/row/rowset/row", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("typeID") != null)
					return new Requirement();
				if (attributes.getValue("bonusType") != null)
					return new Bonus();
				return null;
			}
		});
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row/rowset/row", "addSkillDetail");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addSkill");
		return digester;
	}

	public Response getSkills() throws IOException, SAXException {
		Digester digester = getDigester();
		return (Response) digester.parse(APIURL);
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
