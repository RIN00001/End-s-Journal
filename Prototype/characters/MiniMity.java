package characters;

import Inputs.InputHelper;
import diary.DiaryManager;
import diary.DiaryPrompt;
import java.util.List;

public class MiniMity extends Character {

    public MiniMity() {
        super("MiniMity", List.of(
                "Did you know I used to want to be a cloud?",
                "I miss swings... and stars...",
                "Everything felt possible, didn’t it?",
                "Do you still remember the stories you made up in your head?",
                "I used to laugh at the silliest things.",
                "I wonder if you still have that spark of imagination.",
                "How would you feel if you could touch the sky?",
                "Beyond the clouds, there’s a whole world of dreams waiting for you.",
                "Remember when we used to play pretend?",
                "You used to dream of flying, didn’t you?"
        ));
    }
    private final List<DiaryPrompt> prompts = List.of(
            new DiaryPrompt("Joy", "Write about something that made you laugh as a kid.", "MiniMity"),
            new DiaryPrompt("Dreams", "Describe a dream you had when you were little.", "MiniMity"),
            new DiaryPrompt("Play", "What was your favorite game or toy?", "MiniMity")
    );
    @Override
        public void runLevel5Event(DiaryManager diaryManager) {
        System.out.println("\nMiniMity Plays around playfully...");
        System.out.println("\nHey, Do you still remember what made you laugh as a kid?");
        System.out.println("Well, i have something for you...");
        System.out.println("Wanna write about it?");

        System.out.println("[1] Yes, I want to write about it.");
        System.out.println("[2] No, I don't feel like it right now.");
        int choice = InputHelper.readIntInRange(1, 2);
        if (choice == 1) {
            DiaryPrompt prompt = new DiaryPrompt(
                "Reconnect",
                "What would your child self want you to remember?",
                "MiniMity"
            );
            System.out.println("Theme: " + prompt.getTheme());
            diaryManager.setCurrentPrompt(prompt);
        } else {
            System.out.println("Maybe another time then.");

        }
    } 
    @Override
        public void runLevel10Event( DiaryManager diaryManager) {
            System.out.println("\nMiniMity looks thoughtful...");
            System.out.println("Do you remember how it felt to laugh without reason?");
            System.out.println("Would you like to write about a time you laughed for no reason?");
            System.out.println("[1] Yes, I'd love to write about it.");
            System.out.println("[2] Not right now.");
            int choice = InputHelper.readIntInRange(1, 2);
            if (choice == 1) {
                DiaryPrompt prompt = new DiaryPrompt(
                    "Laughter",
                    "Describe a moment when you laughed just because you felt happy.",
                    "MiniMity"
                );
                System.out.println("Theme: " + prompt.getTheme());
            diaryManager.setCurrentPrompt(prompt);
            } else {
                System.out.println("That's okay, maybe next time.");
            }
        }
    @Override
        public void runLevel15Event(    DiaryManager diaryManager) {
            System.out.println("\nMiniMity gazes at the sky, lost in thought...");
            System.out.println("We used to dream big, didn't we?");
            System.out.println("How about writing about a big or wild dream you had when you were younger?");
            System.out.println("[1] Yes, I want to write about my dream.");
            System.out.println("[2] No, maybe later.");
            int choice = InputHelper.readIntInRange(1, 2);
            if (choice == 1) {
                DiaryPrompt prompt = new DiaryPrompt(
                    "Big Dreams",
                    "Write about a big or wild dream you had when you were younger.",
                    "MiniMity"
                );
                System.out.println("Theme: " + prompt.getTheme());
                diaryManager.setCurrentPrompt(prompt);
            } else {
                System.out.println("No worries, you can always dream later.");
            }
        }
    @Override
    public DiaryPrompt givePrompt() {
        System.out.println("Which theme would you like to write about?");
        for (int i = 0; i < prompts.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + prompts.get(i).getTheme());
        }
        int choice = InputHelper.readIntInRange(1, prompts.size());
        DiaryPrompt selectedPrompt = prompts.get(choice - 1);
        System.out.println("Theme: " + selectedPrompt.getTheme());
        System.out.println(" " + selectedPrompt.getMessage());
        return selectedPrompt;
    }
}
