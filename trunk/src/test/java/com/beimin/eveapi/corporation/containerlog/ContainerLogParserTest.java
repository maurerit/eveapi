package com.beimin.eveapi.corporation.containerlog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContainerLogParserTest extends FullAuthParserTest {
	public ContainerLogParserTest() {
		super(ApiPath.CORPORATION, ApiPage.CONTAINER_LOG);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		ContainerLogParser parser = ContainerLogParser.getInstance();
		ContainerLogResponse response = parser.getResponse(auth);
		assertNotNull(response);
		List<ApiContainerLog> containerLogs = response.getContainerLogs();
		assertNotNull(containerLogs);
		assertEquals(23, containerLogs.size());
	}
}