package diary;

import game.GameState;
import java.time.LocalDate;

public class PromptedDiaryEntry extends DiaryEntry {
    private String theme;
    private String source;

    public PromptedDiaryEntry(LocalDate date, String content, String title, String theme, String source) {
        super(date, content, title);
        this.theme = theme;
        this.source = source;
    }

    public String getTheme() {
        return theme;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String getEntryType() {
        return "Prompted: " + theme + " (from " + source + ")";
    }

    @Override
    public void applyEffect(GameState state) {
        switch (source.toLowerCase()) {
            case "lily" -> state.increaseAffection("Lily", 2);
            case "young" -> state.increaseAffection("Young", 2);
            case "adult" -> state.increaseAffection("Adult", 2);
            default -> state.increaseAffection("Lily", 1); // fallback
        }

        if (theme.equalsIgnoreCase("Forgiveness")) {
            state.unlockMemory("Forgiveness");
        }
    }
}
