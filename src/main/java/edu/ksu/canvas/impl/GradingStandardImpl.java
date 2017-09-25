package edu.ksu.canvas.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.reflect.TypeToken;

import edu.ksu.canvas.interfaces.GradingStandardReader;
import edu.ksu.canvas.interfaces.GradingStandardWriter;
import edu.ksu.canvas.model.GradingStandard;
import edu.ksu.canvas.net.RestClient;
import edu.ksu.canvas.oauth.OauthToken;

public class GradingStandardImpl extends BaseImpl<GradingStandard, GradingStandardReader, GradingStandardWriter> implements GradingStandardReader, GradingStandardWriter {

	private static final Logger LOG = Logger.getLogger(GradingStandardImpl.class);
			
	public GradingStandardImpl(String canvasBaseUrl, Integer apiVersion, OauthToken oauthToken, RestClient restClient,
			int connectTimeout, int readTimeout, Integer paginationPageSize) {
		super(canvasBaseUrl, apiVersion, oauthToken, restClient, connectTimeout, readTimeout, paginationPageSize);
	}

	@Override
	public List<GradingStandard> getGradingStandardsForAccount(Integer accountId) throws IOException {
		LOG.debug("Looking up grading standards for account " + accountId);
        String url = buildCanvasUrl("/accounts/" + accountId + "/grading_standards", Collections.emptyMap());
        return getListFromCanvas(url);
	}

	@Override
	protected Type listType() {
		return new TypeToken<List<GradingStandard>>(){}.getType();
	}

	@Override
	protected Class<GradingStandard> objectType() {
		return GradingStandard.class;
	}

}
