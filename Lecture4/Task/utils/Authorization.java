package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.OAuth2_Token;
import data.User;
import org.json.JSONObject;

import java.io.IOException;

public class Authorization {

    private ObjectMapper mapper = new ObjectMapper();
    private RequestExecutor execute = new RequestExecutor();

    public OAuth2_Token getOAuth2Token(User user) throws IOException {
        String responseString = execute.post(Constant.tokenURL, user, "authorisation");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        OAuth2_Token resultToken = mapper.readValue(responseString, OAuth2_Token.class);
        System.out.println("OAuth2 token is: " + resultToken.getAccess_token());
        return resultToken;
    }
}
