package edu.ksu.canvas.impl;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.google.common.collect.ImmutableMap;
import com.google.gson.reflect.TypeToken;

import edu.ksu.canvas.interfaces.CustomColumnReader;
import edu.ksu.canvas.interfaces.CustomColumnWriter;
import edu.ksu.canvas.model.CustomColumn;
import edu.ksu.canvas.net.Response;
import edu.ksu.canvas.net.RestClient;
import edu.ksu.canvas.oauth.OauthToken;

public class CustomColumnsImpl extends BaseImpl<CustomColumn, CustomColumnReader, CustomColumnWriter> implements CustomColumnReader, CustomColumnWriter {
    private static final Logger LOG = Logger.getLogger(CustomColumnsImpl.class);

    public CustomColumnsImpl(String canvasBaseUrl, Integer apiVersion, OauthToken oauthToken, RestClient restClient, int connectTimeout, int readTimeout, Integer paginationPageSize) {
        super(canvasBaseUrl, apiVersion, oauthToken, restClient, connectTimeout, readTimeout, paginationPageSize);
    }

	@Override
	public List<CustomColumn> listCustomColumns(Integer courseId, Boolean includeHidden) throws IOException {
		LOG.debug("Listing custom columns for course " + courseId);
		ImmutableMap<String, List<String>> parameters = ImmutableMap.<String, List<String>>builder()
                .put("include_hidden", Arrays.asList(Boolean.toString(includeHidden))).build();
		String url = buildCanvasUrl("/courses/" + courseId + "/custom_gradebook_columns", parameters);
        return getListFromCanvas(url);
	}
	
	@Override
	public Optional<CustomColumn> createCustomColumn(Integer courseId, String title, Optional<Integer> position,
			Optional<Boolean> hidden) throws IOException {
		Map<String, List<String>> postParameters = new HashMap<>();
		postParameters.put("column[title]", Collections.singletonList(title));
		position.ifPresent(i -> postParameters.put("column[position]", Collections.singletonList(i.toString())));
		hidden.ifPresent(i -> postParameters.put("column[hidden]", Collections.singletonList(i.toString())));
		String url = buildCanvasUrl("/courses/" + courseId + "/custom_gradebook_columns", Collections.emptyMap());
		LOG.debug("create URI for custom column creation creation : " + url);
		Response response = canvasMessenger.sendToCanvas(oauthToken, url, postParameters);
        if (response.getErrorHappened() || ( response.getResponseCode() != 200)) {
            LOG.debug("Failed to create columns, error message: " + response.toString());
            return Optional.empty();
        }
        return responseParser.parseToObject(CustomColumn.class,response);
	}
	
    @Override
    protected Type listType() {
        return new TypeToken<List<CustomColumn>>(){}.getType();
    }

    @Override
    protected Class<CustomColumn> objectType() {
        return CustomColumn.class;
    }


}
