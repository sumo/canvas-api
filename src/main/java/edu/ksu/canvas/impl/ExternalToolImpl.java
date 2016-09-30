package edu.ksu.canvas.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.reflect.TypeToken;

import edu.ksu.canvas.interfaces.ExternalToolReader;
import edu.ksu.canvas.interfaces.ExternalToolWriter;
import edu.ksu.canvas.model.ExternalTool;
import edu.ksu.canvas.net.RestClient;
import edu.ksu.canvas.requestOptions.ListExternalToolsOptions;

public class ExternalToolImpl extends BaseImpl<ExternalTool, ExternalToolReader, ExternalToolWriter> implements ExternalToolReader, ExternalToolWriter {
    private static final Logger LOG = Logger.getLogger(ExternalToolImpl.class);

    public ExternalToolImpl(String canvasBaseUrl, Integer apiVersion, String oauthToken, RestClient restClient, int connectTimeout, int readTimeout, Integer paginationPageSize) {
        super(canvasBaseUrl, apiVersion, oauthToken, restClient, connectTimeout, readTimeout, paginationPageSize);
    }

    @Override
    public List<ExternalTool> listExternalToolsInAccount(ListExternalToolsOptions options) throws IOException {
        LOG.debug("Getting list of external tools in account " + options.getId());
        String url = buildCanvasUrl("accounts/" + options.getId() + "/external_tools", options.getOptionsMap());
        //Response response = canvasMessenger.getSingleResponseFromCanvas(oauthToken, url);
        return getListFromCanvas(url);
    }

    @Override
    public List<ExternalTool> listExternalToolsInCourse(ListExternalToolsOptions options) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ExternalTool> listExternalToolsInGroup(ListExternalToolsOptions options) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Type listType() {
        return new TypeToken<List<ExternalTool>>(){}.getType();
    }

    @Override
    protected Class<ExternalTool> objectType() {
        return ExternalTool.class;
    }
}
