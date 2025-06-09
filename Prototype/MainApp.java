import game.GameState;
import ui.GameUI;

public class MainApp {
    public static void main(String[] args) {
        GameState state = new GameState();
        GameUI ui = new GameUI(state);
        ui.start();
    }
}
