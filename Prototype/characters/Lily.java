package characters;

import Inputs.InputHelper;
import diary.DiaryManager;
import diary.DiaryPrompt;
import java.util.List;

public class Lily extends Character {

    public Lily() {
        super("Lily", List.of(
                "Hey... you okay today?",
                "Lets take a breath together.",
                "I'm here if you want to talk.",
                "You've been through more than you admit.",
                "You're. stronger than you think.",
                "I know you feel alone, but I'm here.",
                "You don't have to face this alone.",
                "It's okay to not be okay.",
                "You can trust me, I won't judge.",
                "Sometimes, just being here is enough.",
                "You can share your feelings with me."
        ));
    }
    private final List<DiaryPrompt> prompts = List.of(
            new DiaryPrompt("Comfort", "Write about a time you felt safe or comforted, even if it was just a small moment.", "Lily"),
            new DiaryPrompt("Strength", "Describe a challenge you faced and how you managed to get through it, even if it was hard.", "Lily"),
            new DiaryPrompt("Connection", "Write about someone who made you feel less alone, or someone you wish you could talk to.", "Lily")
    );

    @Override
    public void runLevel5Event(DiaryManager diaryManager) {
        System.out.println("\nLily sits beside you quietly, offering a gentle smile.");
        System.out.println("\nAre you okay today?");
        System.out.println("Do you still remember what made you laugh as a kid?");
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
    public void runLevel10Event(DiaryManager diaryManager) {
        System.out.println("\nLily sits beside you quietly, offering a gentle smile.");
        System.out.println("Sometimes, sharing your worries can lighten the load.");
        System.out.println("Would you like to write about something that's been on your mind?");

        System.out.println("[1] Yes, I'll write about it.");
        System.out.println("[2] Not right now.");
        int choice = InputHelper.readIntInRange(1, 2);
        if (choice == 1) {
            DiaryPrompt prompt = new DiaryPrompt(
                    "Worries",
                    "Write about something that's been weighing on you lately.",
                    "Lily"
            );
            System.out.println("Theme: " + prompt.getTheme());
            diaryManager.setCurrentPrompt(prompt);
        } else {
            System.out.println("Maybe another time then.");
        }
    }

    @Override
    public void runLevel15Event(DiaryManager diaryManager) {
        System.out.println("\nLily offers you a warm cup of tea.");
        System.out.println("Reflecting on your progress can be healing.");
        System.out.println("Would you like to write about how far you've come?");

        System.out.println("[1] Yes, I'll write about it.");
        System.out.println("[2] Maybe later.");
        int choice = InputHelper.readIntInRange(1, 2);
        if (choice == 1) {
            DiaryPrompt prompt = new DiaryPrompt(
                    "Progress",
                    "Describe a moment when you realized you've grown or changed.",
                    "Lily"
            );
            System.out.println("Theme: " + prompt.getTheme());
            diaryManager.setCurrentPrompt(prompt);
        } else {
            System.out.println("Maybe another time then.");
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
