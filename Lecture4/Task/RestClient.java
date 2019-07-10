import data.Note;
import data.OAuth2_Token;
import data.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestClient {

    public static Note[] getAllNotes(String url, OAuth2_Token token) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpGet.setHeader("authorization", "Bearer" + token.getAccess_token());
        System.out.println("Getting all notes: ");
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code -------> " + statusCode);
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        System.out.println("Your notes are: ");
        ObjectMapper mapper = new ObjectMapper();
        Note[] note = mapper.readValue(responseString, Note[].class);
        for (Note noteInfo : note) {
            System.out.println("Id: " + noteInfo.getId() + " Data.Note: " + noteInfo.getContent());
        }
        return note;
    }

    public static User registerUser(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        String usersJsonToString = mapper.writeValueAsString(user);
        httpPost.setEntity(new StringEntity(usersJsonToString, ContentType.APPLICATION_JSON));
        System.out.println("Create user: ");
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code -------> " + statusCode);
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        User resultUser = mapper.readValue(responseString, User.class);
        return resultUser;
    }

    public static OAuth2_Token getOAuth2Token(User user, String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setHeader("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
        List<NameValuePair> formData = new ArrayList<>();
        formData.add(new BasicNameValuePair("grant_type", "password"));
        formData.add(new BasicNameValuePair("scope", "read write"));
        formData.add(new BasicNameValuePair("username", user.getEmail()));
        formData.add(new BasicNameValuePair("password", user.getPassword()));
        httpPost.setEntity(new UrlEncodedFormEntity(formData));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Getting of OAuth2 token: ");
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code -------> " + statusCode);
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        OAuth2_Token token = mapper.readValue(responseString, OAuth2_Token.class);
        System.out.println("OAuth2 token is: " + token.getAccess_token());
        return token;
    }

    public static Note createNote(OAuth2_Token token, String url, String note) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("authorization", "Bearer" + token.getAccess_token());
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("content", note);
        String JSON_STRING = node.toString();
        httpPost.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
        System.out.println("Create new note: ");
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code -------> " + statusCode);
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        Note resultNote = mapper.readValue(responseString, Note.class);
        System.out.println("Your new note is: " + resultNote.getContent());
        return resultNote;
    }

    public static Note getNote(OAuth2_Token token, String url, int id) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url + "/" + id);
        httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpGet.setHeader("authorization", "Bearer" + token.getAccess_token());
        System.out.println("Getting note by ID: ");
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code -------> " + statusCode);
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        Note note = mapper.readValue(responseString, Note.class);
        System.out.println("Id: " + note.getId() + " Data.Note: " + note.getContent());
        return note;
    }

    public static Note updateNote(OAuth2_Token token, String url, int id, String newText) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url + "/" + id);
        httpPut.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPut.setHeader("authorization", "Bearer" + token.getAccess_token());
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("content", newText);
        String JSON_STRING = node.toString();
        httpPut.setEntity(new StringEntity(JSON_STRING, ContentType.APPLICATION_JSON));
        System.out.println("Update note: ");
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPut);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code -------> " + statusCode);
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        Note updatedNote = mapper.readValue(responseString, Note.class);
        System.out.println("Id: " + updatedNote.getId() + " Data.Note: " + updatedNote.getContent());
        return updatedNote;
    }

    public static void deleteNote(OAuth2_Token token, String url, int id) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(url + "/" + id);
        httpDelete.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpDelete.setHeader("authorization", "Bearer" + token.getAccess_token());
        System.out.println("Deleting of note: ");
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpDelete);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code -------> " + statusCode);
    }
}
