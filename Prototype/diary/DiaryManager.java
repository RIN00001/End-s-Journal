package diary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiaryManager {
    private List<DiaryEntry> entries = new ArrayList<>();
    private DiaryPrompt currentPrompt = null;

    public void addEntry(DiaryEntry entry) {
        entries.add(entry);
        System.out.println("📝 Diary entry saved successfully.");
    }

    public void viewEntries() {
        if (entries.isEmpty()) {
            System.out.println("No diary entries yet.");
            return;
        }

        System.out.println("\n📚 Your Diary Entries:");
        for (int i = 0; i < entries.size(); i++) {
            DiaryEntry entry = entries.get(i);
            System.out.printf("[%d] %s - %s (%s)\n", i + 1, entry.getDate(), entry.getTitle(), entry.getEntryType());
        }

        System.out.println("View entry details? [Y/N]");
        String choice = new java.util.Scanner(System.in).nextLine().trim().toLowerCase();
        if (choice.equals("y")) {
            System.out.print("Enter entry number: ");
            try {
                int index = Integer.parseInt(new java.util.Scanner(System.in).nextLine()) - 1;
                viewEntryDetails(index);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    public void viewEntryDetails(int index) {
        if (index < 0 || index >= entries.size()) {
            System.out.println("Invalid entry number.");
            return;
        }

        DiaryEntry entry = entries.get(index);
        System.out.println("\n📖 Entry Details:");
        System.out.println("Date: " + entry.getDate());
        System.out.println("Title: " + entry.getTitle());
        System.out.println("Type: " + entry.getEntryType());
        System.out.println("Content:\n" + entry.getContent());
    }


    public DiaryPrompt getCurrentPrompt() {
        return currentPrompt;
    }

    public void setCurrentPrompt(DiaryPrompt prompt) {
        this.currentPrompt = prompt;
    }

    public void clearPrompt() {
        this.currentPrompt = null;
    }

    public List<DiaryEntry> getEntries() {
        return Collections.unmodifiableList(entries);
    }
}
