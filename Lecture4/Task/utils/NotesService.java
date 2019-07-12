package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Note;
import data.OAuth2_Token;
import data.User;
import org.json.JSONObject;

import java.io.IOException;

public class NotesService {

    private ObjectMapper mapper = new ObjectMapper();
    private RequestExecutor execute = new RequestExecutor();

    public Note[] getAllNotes(OAuth2_Token token) throws IOException {
        System.out.println("Your notes are: ");
        Note[] note = mapper.readValue(execute.getOrDelete(Constant.getAllCreateNotesURL, token, "Get"), Note[].class);
        for (Note noteInfo : note) {
            System.out.println("Id: " + noteInfo.getId() + " Note: " + noteInfo.getContent());
        }
        return note;
    }

    public User registerUser(String email, String password) throws IOException {
        System.out.println("User's registration: ");
        String responseString = execute.post(Constant.registerURL, email, password, "registration");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        User resultUser = mapper.readValue(responseString, User.class);
        resultUser.setPassword(password);
        return resultUser;
    }

    public Note createNote(OAuth2_Token token, String note) throws IOException {
        String responseString = execute.post(token, Constant.getAllCreateNotesURL, note, "createNote");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        Note resultNote = mapper.readValue(responseString, Note.class);
        System.out.println("Your new note is: " + resultNote.getContent());
        return resultNote;
    }

    public Note getNote(OAuth2_Token token) throws IOException {
        System.out.println("Your notes is: ");
        Note note = mapper.readValue(execute.getOrDelete(Constant.getNoteURL,token, "Get"), Note.class);
        System.out.println("Id: " + note.getId() + " Note: " + note.getContent());
        return note;
    }

    public Note updateNote(OAuth2_Token token, String newText) throws IOException {
        System.out.println("Updating of Note: ");
        String responseString = execute.put(Constant.deleteUpdateURL, newText, token);
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        Note updatedNote = mapper.readValue(responseString, Note.class);
        System.out.println("Id: " + updatedNote.getId() + " Data.Note: " + updatedNote.getContent());
        return updatedNote;
    }

    public void deleteNote(OAuth2_Token token) throws IOException {
        execute.getOrDelete(Constant.deleteUpdateURL, token, "Delete");
        System.out.println("Note was deleted");
    }
}