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
import java.util.HashMap;
import java.util.List;

class RequestExecutor {

    private String post(String url, HashMap headers, List formData, String JSON_STRING) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        for (HashMap.Entry entry : (Iterable<HashMap.Entry>) headers.entrySet()) {
            httpPost.setHeader(entry.getKey().toString(), entry.getValue().toString());
        }
        if (formData != null) {
            httpPost.setEntity(new UrlEncodedFormEntity(formData, "UTF-8"));
        }
        else{
            httpPost.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
        }
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
        RequestExecutorHelper.getStatusCode(closeableHttpResponse);
        return EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
    }

    public String post(String url, HashMap headers, String JSON_STRING) throws IOException {
        List formData = null;
        return post(url, headers, formData, JSON_STRING);
    }

    public String post(String url, HashMap headers, List formData) throws IOException {
        String JSON_STRING = null;
        return post(url, headers, formData, JSON_STRING);
    }

    public String put(String url, HashMap headers, String JSON_STRING) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpEntityEnclosingRequestBase httpPut = new HttpPut(url);
        for (HashMap.Entry entry : (Iterable<HashMap.Entry>) headers.entrySet()) {
            httpPut.setHeader(entry.getKey().toString(), entry.getValue().toString());
        }
        httpPut.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPut);
        RequestExecutorHelper.getStatusCode(closeableHttpResponse);
        return EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
    }

    public String get(String url, HashMap headers) throws IOException  {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpRequestBase httpGet = new HttpGet(url);
        for (HashMap.Entry entry : (Iterable<HashMap.Entry>) headers.entrySet()) {
            httpGet.setHeader(entry.getKey().toString(), entry.getValue().toString());
        }
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
        RequestExecutorHelper.getStatusCode(closeableHttpResponse);
        HttpEntity entity = closeableHttpResponse.getEntity();
        return EntityUtils.toString(entity);
    }

    public static void delete(String url, HashMap headers) throws IOException  {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpRequestBase httpDelete = new HttpDelete(url);
        for (HashMap.Entry entry : (Iterable<HashMap.Entry>) headers.entrySet()) {
            httpDelete.setHeader(entry.getKey().toString(), entry.getValue().toString());
        }
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpDelete);
        RequestExecutorHelper.getStatusCode(closeableHttpResponse);
    }
}