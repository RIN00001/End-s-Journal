package characters;

import diary.DiaryEntry;
import game.MityState;
import java.util.ArrayList;
import java.util.List;

public class Mity {
    private MityState currentState;
    private int diaryCount;
    private int consistencyScore;
    private List<DiaryEntry> writtenEntries;

    public Mity() {
        this.currentState = MityState.COLD;
        this.diaryCount = 0;
        this.consistencyScore = 0;
        this.writtenEntries = new ArrayList<>();
    }

    public void writeDiary(DiaryEntry entry) {
        writtenEntries.add(entry);
        diaryCount++;

        if (diaryCount == 3 && currentState == MityState.HARDENING) {
            currentState = MityState.REFLECTING;
        }


    }

    public void reflectOnProgress() {
    }

    public MityState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MityState newState) {
        this.currentState = newState;
    }

    public int getDiaryCount() {
        return diaryCount;
    }

    public List<DiaryEntry> getWrittenEntries() {
        return writtenEntries;
    }

    public int getConsistencyScore() {
        return consistencyScore;
    }

    public void setConsistencyScore(int consistencyScore) {
        this.consistencyScore = consistencyScore;
    }
}
