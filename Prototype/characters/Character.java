package characters;

import diary.DiaryManager;
import diary.DiaryPrompt;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int affection;
    protected List<String> dialogueLines;

    public Character(String name, List<String> dialogueLines) {
        this.name = name;
        this.dialogueLines = dialogueLines;
        this.affection = 0;
    }

    public String getName() {
        return name;
    }

    public int getAffection() {
        return affection;
    }

    public void increaseAffection(int amount, DiaryManager diaryManager) {
        this.affection = Math.min(this.affection + amount, 100);

        // milestone triggers
        if (affection == 5) runLevel5Event(diaryManager);
        if (affection == 10) runLevel10Event(diaryManager);
        if (affection == 15) runLevel15Event(diaryManager);
    }

    public void talk() {
        if (dialogueLines != null && !dialogueLines.isEmpty()) {
            int index = (int) (Math.random() * dialogueLines.size());
            System.out.println(name + ": " + dialogueLines.get(index));
        } else {
            System.out.println(name + " has nothing to say right now.");
        }
    }

    public abstract DiaryPrompt givePrompt();

    public abstract void runLevel5Event(DiaryManager diaryManager);
    public abstract void runLevel10Event(DiaryManager diaryManager);
    public abstract void runLevel15Event(DiaryManager diaryManager);
}
