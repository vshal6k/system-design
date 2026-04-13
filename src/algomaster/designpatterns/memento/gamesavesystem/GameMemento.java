package algomaster.designpatterns.memento.gamesavesystem;

public class GameMemento {
    private int health;
    private int level;
    private int position;

    public GameMemento(int health, int level, int position) {
        this.health = health;
        this.level = level;
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getPosition() {
        return position;
    }

}
