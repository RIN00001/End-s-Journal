package diary;
import game.GameState;
import java.time.LocalDate;
public abstract class DiaryEntry {

    protected LocalDate date;
    protected String content;
    protected String title;

    public DiaryEntry(LocalDate date, String content,String title) {
        this.date = date;
        this.content = content;
        this.title = title;
    }

    public abstract String getEntryType();

    public abstract void applyEffect(GameState state);

    public LocalDate getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return (title == null || title.isEmpty()) ? "Untitled" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
