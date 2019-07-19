package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import data.NoteDto;
import data.UserDto;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NotesService {

    private ObjectMapper mapper = new ObjectMapper();
    private ObjectNode node = mapper.createObjectNode();
    private RequestExecutor execute = new RequestExecutor();

    public NoteDto[] getAllNotes(UserDto user) throws IOException {
        System.out.println("Your notes are: ");
        HashMap<String, String> headers = setHeaders(user);
        NoteDto[] note = mapper.readValue(execute.get(Constant.GET_NOTES_URL, headers), NoteDto[].class);
        for (NoteDto noteInfo : note) {
            System.out.println(noteInfo.getNoteData());
        }
        return note;
    }

    public UserDto registerUser(String email, String password) throws IOException {
        ClientAuthorization authorization = new ClientAuthorization();
        System.out.println("User's registration: ");
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        node.put("email", email);
        node.put("password", password);
        String jsonString = node.toString();
        String responseString = execute.post(Constant.REGISTER_URL, headers, jsonString);
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        UserDto resultUser = mapper.readValue(responseString, UserDto.class);
        resultUser.setPassword(password);
        authorization.authorize(resultUser);
        return resultUser;
    }

    public NoteDto createNote(UserDto user, String note) throws IOException {
        node.put("content", note);
        String jsonString = node.toString();
        HashMap<String, String> headers = setHeaders(user);
        String responseString = execute.post(Constant.GET_NOTES_URL, headers, jsonString);
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        NoteDto resultNote = mapper.readValue(responseString, NoteDto.class);
        System.out.println("Your new note is: " + resultNote.getContent());
        return resultNote;
    }

    public NoteDto getNote(UserDto user, NoteDto note) throws IOException {
        HashMap<String, String> headers = setHeaders(user);
        String url = Constant.GET_NOTES_URL + "/" + note.getId();
        System.out.println("Your notes is: ");
        note = mapper.readValue(execute.get(url, headers), NoteDto.class);
        System.out.println(note.getNoteData());
        return note;
    }

    public NoteDto updateNote(UserDto user, String newText, NoteDto note) throws IOException {
        String url = Constant.GET_NOTES_URL + "/" + note.getId();
        System.out.println("Updating of Note: ");
        HashMap<String, String> headers = setHeaders(user);
        node.put("content", newText);
        String jsonString = node.toString();
        String responseString = execute.put(url, headers, jsonString);
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API ------> " + responseJson);
        note = mapper.readValue(responseString, NoteDto.class);
        note.getNoteData();
        return note;
    }

    public void deleteNote(UserDto user, NoteDto note) throws IOException {
        String url = Constant.GET_NOTES_URL + "/" + note.getId();
        HashMap<String, String> headers = setHeaders(user);
        execute.delete(url, headers);
        System.out.println("Note was deleted");
    }

    private HashMap<String, String> setHeaders(UserDto user){
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("Authorization", "Bearer " + user.getToken());
        return headers;
    }
}