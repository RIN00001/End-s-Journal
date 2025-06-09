package game;

import java.util.*;

public class GameState {

    private MityState mityState;
    private Map<String, Integer> affectionMap;
    private Set<String> unlockedMemories;

    public GameState() {
        this.mityState = MityState.COLD;
        this.affectionMap = new HashMap<>();
        this.unlockedMemories = new HashSet<>();
    }

    public MityState getMityState() {
        return mityState;
    }

    public void setMityState(MityState state) {
        this.mityState = state;
    }


    public int getAffection(String characterName) {
        return affectionMap.getOrDefault(characterName, 0);
    }

    public void increaseAffection(String characterName, int amount) {
        int current = affectionMap.getOrDefault(characterName, 0);
        int updated = Math.min(current + amount, 100);
        affectionMap.put(characterName, updated);
    }

    public void unlockMemory(String memoryKey) {
        unlockedMemories.add(memoryKey);
    }

    public boolean hasUnlockedMemory(String memoryKey) {
        return unlockedMemories.contains(memoryKey);
    }

    public void printAffectionStatus() {
        System.out.println(" Mity's Emotional State: " + mityState);
        System.out.println(" Affection Levels:");
        for (Map.Entry<String, Integer> entry : affectionMap.entrySet()) {
            System.out.printf("- %s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}
