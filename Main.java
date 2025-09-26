package notesapp;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file = "notes.txt";
        NotesManager manager = new NotesManager(file);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" 1. Add Note\n 2. Show Notes\n 3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter note: ");
                String note = scanner.nextLine();
                try {
                    manager.addNote(note);
                    System.out.println("Note added.");
                } catch (IOException e) {
                    System.out.println("Failed to add note: " + e.getMessage());
                }
            } else if (choice == 2) {
                try {
                    List<String> notes = manager.readNotes();
                    System.out.println("--- Notes ---");
                    for (String n : notes) {
                        System.out.println(n);
                    }
                } catch (IOException e) {
                    System.out.println("Failed to read notes: " + e.getMessage());
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
