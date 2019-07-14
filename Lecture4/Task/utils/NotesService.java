package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import data.NoteDto;
import data.UserDto;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class NotesService {

    private ObjectMapper mapper = new ObjectMapper();
    private ObjectNode node = mapper.createObjectNode();
    private RequestExecutor execute = new RequestExecutor();

    public NoteDto[] getAllNotes(UserDto user) throws IOException {
        System.out.println("Your notes are: ");
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Authorization", "Bearer " + user.getToken());
        NoteDto[] note = mapper.readValue(execute.get(Constant.getNotesURL, headers), NoteDto[].class);
        for (NoteDto noteInfo : note) {
            System.out.println("Id: " + noteInfo.getId() + " Note: " + noteInfo.getContent());
        }
        return note;
    }

    public UserDto registerUser(String email, String password) throws IOException {
        ClientAuthorization authorization = new ClientAuthorization();
        System.out.println("User's registration: ");
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        node.put("email", email);
        node.put("password", password);
        String JSON_STRING = node.toString();
        String responseString = execute.post(Constant.registerURL, headers, JSON_STRING);
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        UserDto resultUser = mapper.readValue(responseString, UserDto.class);
        resultUser.setPassword(password);
        authorization.getOAuth2Token(resultUser);
        return resultUser;
    }

    public NoteDto createNote(UserDto user, String note) throws IOException {
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Authorization", "Bearer " + user.getToken());
        node.put("content", note);
        String JSON_STRING = node.toString();
        String responseString = execute.post(Constant.getNotesURL, headers, JSON_STRING);
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        NoteDto resultNote = mapper.readValue(responseString, NoteDto.class);
        System.out.println("Your new note is: " + resultNote.getContent());
        return resultNote;
    }

    public NoteDto getNote(UserDto user, NoteDto note) throws IOException {
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Authorization", "Bearer " + user.getToken());
        String url = Constant.getNotesURL + "/" + note.getId();
        System.out.println("Your notes is: ");
        note = mapper.readValue(execute.get(url, headers), NoteDto.class);
        System.out.println("Id: " + note.getId() + " Note: " + note.getContent());
        return note;
    }

    public NoteDto updateNote(UserDto user, String newText, NoteDto note) throws IOException {
        String url = Constant.getNotesURL + "/" + note.getId();
        System.out.println("Updating of Note: ");
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Authorization", "Bearer " + user.getToken());
        node.put("content", newText);
        String JSON_STRING = node.toString();
        String responseString = execute.put(url, headers, JSON_STRING);
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        note = mapper.readValue(responseString, NoteDto.class);
        note.getNoteData();
        return note;
    }

    public void deleteNote(UserDto user, NoteDto note) throws IOException {
        String url = Constant.getNotesURL + "/" + note.getId();
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Authorization", "Bearer " + user.getToken());
        execute.delete(url, headers);
        System.out.println("Note was deleted");
    }
}