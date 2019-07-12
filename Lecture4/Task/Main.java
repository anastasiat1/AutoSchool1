import utils.Authorization;
import utils.NotesService;
import data.OAuth2_Token;
import data.User;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        Authorization authorization = new Authorization();
        NotesService restClient = new NotesService();
        User registeredUser = restClient.registerUser(System.currentTimeMillis() + "test@m.by", "178234");
        OAuth2_Token token = authorization.getOAuth2Token(registeredUser);
        System.out.println("First note creation: ");
        restClient.createNote(token, "111111111");
        System.out.println("Second note creation: ");
        restClient.createNote(token, "2222222222");
        restClient.getAllNotes(token);
        restClient.getNote(token);
        restClient.updateNote(token,"33333");
        restClient.deleteNote(token);
        restClient.getAllNotes(token);
    }
}