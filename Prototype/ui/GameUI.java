package ui;

import Inputs.InputHelper;
import characters.Lily;
import diary.*;
import game.GameState;

import java.time.LocalDate;

public class GameUI {

    private GameState state;
    private Lily lily;
    private DiaryManager diaryManager;

    public GameUI(GameState state) {
        this.state = state;
        this.lily = new Lily();
        this.diaryManager = new DiaryManager();
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("[1] Talk to Lily");
            System.out.println("[2] View Affection Status");
            System.out.println("[3] Write a diary entry");
            System.out.println("[4] View past entries");
            System.out.println("[5] Battle");
            System.out.println("[6] Exit");

            int choice = InputHelper.readIntInRange(1, 5);
            switch (choice) {
                case 1:
                    lily.talk();
                    lily.increaseAffection(1, diaryManager);  // ← pass manager
                    break;
                case 2:
                    state.printAffectionStatus();
                    break;
                case 3:
                    writeDiaryEntry(); // now handles both free + prompted
                    break;
                case 4:
                    diaryManager.viewEntries();
                    break;
                case 5:
                    System.out.println("Thanks for playing.");
                    running = false;
                    break;
            }
        }
    }

    private void writeDiaryEntry() {
        System.out.println("\n📝 Writing a Diary Entry");

        DiaryPrompt prompt = diaryManager.getCurrentPrompt();
        if (prompt != null) {
            System.out.println("Prompt from " + prompt.getSource() + ": " + prompt.getMessage());
        }

        System.out.println("Title:");
        String title = InputHelper.readLine();

        System.out.println("Content (blank line to finish):");
        String content = InputHelper.readMultiLineUntilBlank();

        if (content.isEmpty()) {
            System.out.println("Diary entry not saved (empty content).");
            return;
        }

        if (prompt != null) {
            PromptedDiaryEntry entry = new PromptedDiaryEntry(LocalDate.now(), content, title, prompt.getTheme(), prompt.getSource());
            entry.applyEffect(state); // if it affects state/affection
            diaryManager.addEntry(entry);
            diaryManager.clearPrompt();
        } else {
            FreeDiaryEntry entry = new FreeDiaryEntry(LocalDate.now(), content);
            entry.setTitle(title);
            diaryManager.addEntry(entry);
        }

        // Optional: bonus affection for writing
        lily.increaseAffection(1, diaryManager);
    }
}
