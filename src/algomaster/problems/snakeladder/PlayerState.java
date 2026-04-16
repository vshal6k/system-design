package algomaster.problems.snakeladder;

public class PlayerState {
    private final Player player;
    private int position;

    public PlayerState(Player player, int position) {
        this.player = player;
        this.position = position;
    }

    public PlayerState(Player player){
        this(player, 0);
    }

    public Player getPlayer() {
        return player;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPlayerName(){
        return this.player.getName();
    }

}
