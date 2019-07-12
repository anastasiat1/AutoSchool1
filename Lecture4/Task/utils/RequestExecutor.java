package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import data.OAuth2_Token;
import data.User;
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
    private ObjectMapper mapper = new ObjectMapper();
    ObjectNode node = mapper.createObjectNode();

    private String post(String url, String email, String password, User user, OAuth2_Token token, String note, String type) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        if (token.getAccess_token() == null){
            for (HashMap.Entry entry : Helper.createHeadersHashMapWithoutToken(type).entrySet()) {
                httpPost.setHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        else {
            for (HashMap.Entry entry : Helper.createHeadersHashMap(token).entrySet()) {
                httpPost.setHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        if (email != null && password != null) {
            node.put("email", email);
            node.put("password", password);
            String JSON_STRING = node.toString();
            httpPost.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
        }
        if (token.getAccess_token() != null && note != null){
            node.put("content", note);
            String JSON_STRING = node.toString();
            httpPost.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
        }
        if (user.getEmail() != null) {
            List formData = Helper.createFormDataList(user);
            httpPost.setEntity(new UrlEncodedFormEntity(formData, "UTF-8"));
        }
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
        Helper.getStatusCode(closeableHttpResponse);
        return EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
    }

    String post(String url, String email, String password, String type) throws IOException {
        String note = null;
        return post(url, email, password, new User(), new OAuth2_Token(), note, type);
    }

    String post(String url, User user, String type) throws IOException {
        String note = null;
        String email = null;
        String password = null;
        return post(url, email, password, user, new OAuth2_Token(), note, type);
    }

    String post(OAuth2_Token token, String url, String note, String type) throws IOException {
        String email = null;
        String password = null;
        return post(url, email, password, new User(), token, note, type);
    }

    String put(String url, String note, OAuth2_Token token) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpEntityEnclosingRequestBase httpPut = new HttpPut(url);
        for (HashMap.Entry entry : Helper.createHeadersHashMap(token).entrySet()) {
            httpPut.setHeader(entry.getKey().toString(), entry.getValue().toString());
        }
        node.put("content", note);
        String JSON_STRING = node.toString();
        httpPut.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
        System.out.println("Create new note: ");
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPut);
        Helper.getStatusCode(closeableHttpResponse);
        return EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
    }

    String getOrDelete(String url, OAuth2_Token token, String type) throws IOException  {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpRequestBase method = null;
        if (type.equals("Delete")) {
            method = new HttpDelete(url);
        } else if (type.equals("Get")) {
            method = new HttpGet(url);
        }
        for (HashMap.Entry entry : Helper.createHeadersHashMap(token).entrySet()) {
            method.setHeader(entry.getKey().toString(), entry.getValue().toString());
        }
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(method);
        Helper.getStatusCode(closeableHttpResponse);
        HttpEntity entity = closeableHttpResponse.getEntity();
        if (entity != null){
            return EntityUtils.toString(entity);
        }
        return null;
    }
}