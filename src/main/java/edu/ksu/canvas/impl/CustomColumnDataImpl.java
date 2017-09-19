package edu.ksu.canvas.impl;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.ImmutableMap;
import com.google.gson.reflect.TypeToken;

import edu.ksu.canvas.interfaces.CustomColumnDataReader;
import edu.ksu.canvas.interfaces.CustomColumnDataWriter;
import edu.ksu.canvas.model.ColumnDatum;
import edu.ksu.canvas.model.CustomColumn;
import edu.ksu.canvas.net.RestClient;
import edu.ksu.canvas.oauth.OauthToken;

public class CustomColumnDataImpl extends BaseImpl<ColumnDatum, CustomColumnDataReader, CustomColumnDataWriter> implements CustomColumnDataReader, CustomColumnDataWriter {
    private static final Logger LOG = Logger.getLogger(CustomColumnDataImpl.class);

    public CustomColumnDataImpl(String canvasBaseUrl, Integer apiVersion, OauthToken oauthToken, RestClient restClient, int connectTimeout, int readTimeout, Integer paginationPageSize) {
        super(canvasBaseUrl, apiVersion, oauthToken, restClient, connectTimeout, readTimeout, paginationPageSize);
    }

	@Override
	public List<ColumnDatum> getColumnData(Integer courseId, CustomColumn col, Boolean includeHidden) throws IOException {
		LOG.debug("Listing custom column data for column " + col.getTitle() + " for course " + courseId);
		ImmutableMap<String, List<String>> parameters = ImmutableMap.<String, List<String>>builder()
                .put("include_hidden", Arrays.asList(Boolean.toString(includeHidden))).build();
		String url = buildCanvasUrl("/courses/" + courseId + "/custom_gradebook_columns/" + col.getId() + "/data", parameters);
        return getListFromCanvas(url);
	}

	
    @Override
    protected Type listType() {
        return new TypeToken<List<ColumnDatum>>(){}.getType();
    }

    @Override
    protected Class<ColumnDatum> objectType() {
        return ColumnDatum.class;
    }


}
