package utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class RequestExecutor {

    private String post(String url, Map headers, List formData, String jsonString) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        setHeadersToRequest(httpPost, headers);
        if (formData != null) {
            httpPost.setEntity(new UrlEncodedFormEntity(formData, "UTF-8"));
        }
        if (jsonString != null) {
            httpPost.setEntity(new StringEntity(jsonString, ContentType.APPLICATION_JSON));
        }
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
        RequestExecutorHelper.getStatusCode(closeableHttpResponse);
        return EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
    }

    public String post(String url, Map headers, String jsonString) throws IOException {
        List formData = null;
        return post(url, headers, formData, jsonString);
    }

    public String post(String url, Map headers, List formData) throws IOException {
        String jsonString = null;
        return post(url, headers, formData, jsonString);
    }

    public String put(String url, Map headers, String jsonString) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpEntityEnclosingRequestBase httpPut = new HttpPut(url);
        setHeadersToRequest(httpPut, headers);
        httpPut.setEntity(new StringEntity(jsonString, ContentType.APPLICATION_JSON));
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPut);
        RequestExecutorHelper.getStatusCode(closeableHttpResponse);
        return EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
    }

    public String get(String url, Map headers) throws IOException  {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpRequestBase httpGet = new HttpGet(url);
        setHeadersToRequest(httpGet, headers);
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
        RequestExecutorHelper.getStatusCode(closeableHttpResponse);
        HttpEntity entity = closeableHttpResponse.getEntity();
        return EntityUtils.toString(entity);
    }

    public static void delete(String url, Map headers) throws IOException  {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpRequestBase httpDelete = new HttpDelete(url);
        setHeadersToRequest(httpDelete, headers);
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpDelete);
        RequestExecutorHelper.getStatusCode(closeableHttpResponse);
    }

    public static HttpRequestBase setHeadersToRequest(HttpRequestBase httpRequest, Map<String, String> headers){
        for (Entry entry : headers.entrySet()) {
            httpRequest.setHeader(entry.getKey().toString(), entry.getValue().toString());
        }
        return httpRequest;
    }
}