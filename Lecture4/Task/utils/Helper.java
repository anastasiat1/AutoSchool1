package utils;

import data.OAuth2_Token;
import data.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Helper {

    static int getStatusCode(CloseableHttpResponse closeableHttpResponse){
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code -------> " + statusCode);
        return statusCode;
    }

    static HashMap<String, String> createHeadersHashMapWithoutToken(String type) {
        HashMap<String, String> headers = new HashMap();
        if (type.equals("registration")) {
            headers.put("Content-Type", "application/json;charset=UTF-8");
        }
        else{
            headers.put("Content-Type", "application/x-www-form-urlencoded");
            headers.put("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
        }
        return headers;
    }

    static HashMap<String, String> createHeadersHashMap(OAuth2_Token token) {
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Authorization", "Bearer" + token.getAccess_token());
        return headers;
    }

    static List createFormDataList(User user) {
        List formData = new ArrayList<>();
        formData.add(new BasicNameValuePair("grant_type", "password"));
        formData.add(new BasicNameValuePair("scope", "read write"));
        formData.add(new BasicNameValuePair("username", user.getEmail()));
        formData.add(new BasicNameValuePair("password", user.getPassword()));
        return formData;
    }
}
