package com.beimin.eveapi.corporation.containerlog;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ContainerLogParser extends AbstractApiParser<ContainerLogResponse> {
	public ContainerLogParser() {
		super(ContainerLogResponse.class, 2, ApiPath.CORPORATION, ApiPage.CONTAINER_LOG);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiContainerLog.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addContainerLog");
		return digester;
	}

	public static ContainerLogParser getInstance() {
		return new ContainerLogParser();
	}

	@Override
	public ContainerLogResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}