package characters;

import Inputs.InputHelper;
import diary.DiaryManager;
import diary.DiaryPrompt;
import java.util.List;

public class BigMity extends Character {

    public BigMity() {
        super("BigMity", List.of(
                "You keep pretending you're fine. Why?",
                "I just want you to admit you’re scared to try again.",
                "You’ve been carrying so much… when are you going to set it down?",
                "Some mistakes don’t need fixing. They just need forgiving.",
                "When are you going to stop running from your past?",
                "You think you can just forget everything? It doesn't work that way.",
                "Why do you keep pushing me away? I’m not going anywhere.",
                "How long are you going to keep hiding from yourself?",
                "You think you can just ignore me? I’m part of you, whether you like it or not.",
                "You can’t keep pretending everything’s okay. It’s not.",
                "You’re not alone in this. I’m here, whether you want me to be or not."
        ));
    }

    private final List<DiaryPrompt> prompts = List.of(
            new DiaryPrompt("Pressure", "Write about a time you felt the weight of expectations.", "BigMity"),
            new DiaryPrompt("Regret", "Is there something you wish you had done differently?", "BigMity"),
            new DiaryPrompt("Responsibility", "What burdens have you carried silently?", "BigMity")
    );

    @Override
    public void runLevel5Event(DiaryManager diaryManager) {
        System.out.println("\nBigMity leans in, voice low and honest.");
        System.out.println("\"You ever wonder what happened to the kid you used to be?\"");
        System.out.println("\"Or did you just bury those memories with everything else?\"");
        System.out.println("Want to dig them up and write about it?");
        System.out.println("[1] Yeah, let's see what comes up.");
        System.out.println("[2] No, I'd rather not right now.");
        int choice = InputHelper.readIntInRange(1, 2);
        if (choice == 1) {
            DiaryPrompt prompt = new DiaryPrompt(
                    "Lost Pieces",
                    "What did you leave behind as you grew up? What would it mean to reclaim it?",
                    "BigMity"
            );
            System.out.println("Theme: " + prompt.getTheme());
            diaryManager.setCurrentPrompt(prompt);
        } else {
            System.out.println("\"Suit yourself. But those memories aren't going anywhere.\"");
        }
    }

    @Override
    public void runLevel10Event(DiaryManager diaryManager) {
        System.out.println("\nBigMity crosses their arms, watching you closely.");
        System.out.println("\"You keep carrying all that weight like it’s nothing.\"");
        System.out.println("\"Ever think about what it’s really costing you?\"");
        System.out.println("Want to write about the burdens you never talk about?");
        System.out.println("[1] Fine, I'll write about it.");
        System.out.println("[2] Not today.");
        int choice = InputHelper.readIntInRange(1, 2);
        if (choice == 1) {
            DiaryPrompt prompt = new DiaryPrompt(
                    "Unspoken Burdens",
                    "What are you carrying that no one else sees? Why do you keep it hidden?",
                    "BigMity"
            );
            System.out.println("Theme: " + prompt.getTheme());
            diaryManager.setCurrentPrompt(prompt);
        } else {
            System.out.println("\"Keep hiding it, but it’ll catch up with you eventually.\"");
        }
    }

    @Override
    public void runLevel15Event(DiaryManager diaryManager) {
        System.out.println("\nBigMity sits beside you, gaze unwavering.");
        System.out.println("\"You’ve come a long way, even if you don’t want to admit it.\"");
        System.out.println("\"Ready to face how much you’ve changed? Or are you still running?\"");
        System.out.println("Want to write about your progress?");
        System.out.println("[1] Yeah, I’ll write about it.");
        System.out.println("[2] Maybe later.");
        int choice = InputHelper.readIntInRange(1, 2);
        if (choice == 1) {
            DiaryPrompt prompt = new DiaryPrompt(
                    "Growth",
                    "What’s something you can finally forgive yourself for? How have you changed?",
                    "BigMity"
            );
            System.out.println("Theme: " + prompt.getTheme());
            diaryManager.setCurrentPrompt(prompt);
        } else {
            System.out.println("\"Denial’s comfortable, but it won’t help you move on.\"");
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
