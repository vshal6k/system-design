package algomaster.problems.tictactoe;

public class Player {
    private final Symbol symbol;
    private final String name;
    private final int id;

    public Player(Symbol symbol, String name, int id) {
        this.symbol = symbol;
        this.name = name;
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Player player){
            return player.getId() == this.id;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return id;
    }
}
