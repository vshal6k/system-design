package algomaster.designpatterns.memento.gamesavesystem;

import java.util.ArrayList;
import java.util.List;

public class SaveManager {
    private Game game;
    private List<GameMemento> mementos = new ArrayList<>(3);

    public SaveManager(Game game){
        this.game = game;
    }

    public void save() {
        if(mementos.size() == 3) mementos.remove(0);
        mementos.add(game.save());
    }

    public void restore() {
        if (mementos.isEmpty()) {
            System.out.println("No savepoints to restore to...");
            return;
        }
        game.restore(mementos.getLast());
    }
}
