package notesapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotesManager {
    private String filename;

    public NotesManager(String filename) {
        this.filename = filename;
    }

    public void addNote(String note) throws IOException {
        try (FileWriter fw = new FileWriter(filename, true)) { 
            fw.write(note + System.lineSeparator());
        }
    }

    public List<String> readNotes() throws IOException {
        List<String> notes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                notes.add(line);
            }
        }
        return notes;
    }
}
