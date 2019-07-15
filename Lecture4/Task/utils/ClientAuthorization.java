package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.OAuth2Dto;
import data.UserDto;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientAuthorization {

    private ObjectMapper mapper = new ObjectMapper();
    private RequestExecutor execute = new RequestExecutor();

    public OAuth2Dto getOAuth2Token(UserDto user) throws IOException {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
        List formData = new ArrayList<>();
        formData.add(new BasicNameValuePair("grant_type", "password"));
        formData.add(new BasicNameValuePair("scope", "read write"));
        formData.add(new BasicNameValuePair("username", user.getEmail()));
        formData.add(new BasicNameValuePair("password", user.getPassword()));
        String responseString = execute.post(Constant.getTokenURL, headers, formData);
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        OAuth2Dto resultToken = mapper.readValue(responseString, OAuth2Dto.class);
        System.out.println("OAuth2 token is: " + resultToken.getAccess_token());
        user.setToken(resultToken.getAccess_token());
        return resultToken;
    }
}
