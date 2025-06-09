package diary;

public class DiaryPrompt {
    private final String theme;
    private final String message;
    private final String source;
    private String title;
    public DiaryPrompt(String theme, String message, String source) {
        this.theme = theme;
        this.message = message;
        this.source = source;
    }

    public String getTheme() {
        return theme;
    }

    public String getMessage() {
        return message;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
