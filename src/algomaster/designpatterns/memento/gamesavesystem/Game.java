package algomaster.designpatterns.memento.gamesavesystem;

public class Game {
    private int level = 0;
    private int health = 100;
    private int position = 0;

    public void play() {
        this.level += 1;
        this.position += 10;
    }

    public void takeDamage(int amount) {
        this.health = Math.min(0, this.health - amount);
    }

    public GameMemento save() {
        return new GameMemento(health, level, position);
    }

    public void restore(GameMemento gameMemento) {
        this.health = gameMemento.getHealth();
        this.level = gameMemento.getLevel();
        this.position = gameMemento.getPosition();
    }

    public void display(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Game [level=" + level + ", health=" + health + ", position=" + position + "]";
    }

    public static void main(String[] args) {
        Game game = new Game();
        SaveManager saveManager = new SaveManager(game);

        game.display();
        game.play();
        game.display();
        saveManager.save();

        game.play();
        game.play();
        game.display();

        saveManager.restore();
        game.display();
        
    }

}
