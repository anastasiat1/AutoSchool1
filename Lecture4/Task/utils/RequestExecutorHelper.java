package utils;

import org.apache.http.client.methods.CloseableHttpResponse;

class RequestExecutorHelper {

    public static int getStatusCode(CloseableHttpResponse closeableHttpResponse){
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code -------> " + statusCode);
        return statusCode;
    }
}
