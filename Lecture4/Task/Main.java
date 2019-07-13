import data.NoteDto;
import data.UserDto;
import utils.ClientAuthorization;
import utils.NotesService;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        ClientAuthorization authorization = new ClientAuthorization();
        NotesService notesService = new NotesService();
        String email = System.currentTimeMillis() + "test@m.by";
        String password = "178234";
        UserDto registeredUser = notesService.registerUser(email, password);
        authorization.getOAuth2Token(registeredUser);
        System.out.println("First note creation: ");
        notesService.createNote(registeredUser, "111111111");
        System.out.println("Second note creation: ");
        notesService.createNote(registeredUser, "2222222222");
        NoteDto[] note = notesService.getAllNotes(registeredUser);
        notesService.getNote(registeredUser, note[1]);
        notesService.updateNote(registeredUser,"33333", note[0]);
        notesService.deleteNote(registeredUser, note[1]);
        notesService.getAllNotes(registeredUser);
    }
}