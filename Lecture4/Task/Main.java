import data.OAuth2_Token;
import data.User;

import java.io.IOException;


public class Main {

    private static final String MAIN_URL = "https://taschool-notes-service.herokuapp.com/";
    private static final String ACCOUNTS_URL = "v1/accounts";
    private static final String TOKEN_URL = "oauth/token";
    private static final String accountsUrl = MAIN_URL + ACCOUNTS_URL;
    private static final String tokenUrl = MAIN_URL + TOKEN_URL;
    private static final String NOTES_URL = "v1/notes";
    private static final String notesUrl = MAIN_URL + NOTES_URL;



    public static void main(String[] args) throws IOException {
        RestClient restClient = new RestClient();
        User registeredUser = restClient.registerUser(accountsUrl);
        OAuth2_Token token = restClient.getOAuth2Token(registeredUser, tokenUrl);
        System.out.println("First note creation: ");
        restClient.createNote(token, notesUrl, "111111111");
        System.out.println("Second note creation: ");
        restClient.createNote(token, notesUrl, "2222222222");
        restClient.getAllNotes(notesUrl, token);
        restClient.getNote(token, notesUrl, 96);
        restClient.updateNote(token, notesUrl, 96, "33333");
        restClient.deleteNote(token, notesUrl, 97);
        restClient.getAllNotes(notesUrl, token);
    }
}