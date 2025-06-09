package diary;
import game.GameState;
import java.time.LocalDate;

public class FreeDiaryEntry extends DiaryEntry {

    public FreeDiaryEntry(LocalDate date, String content) {
        super(date, content,"Free");
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String getEntryType() {
        return "Free";
    }
    @Override
    public void applyEffect(GameState state){
        state.increaseAffection("Lily",3);
    }

}
