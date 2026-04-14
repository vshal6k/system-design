package algomaster.problems.tictactoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scoreboard implements GameObserver {

    private Map<Player, Integer> scores = new HashMap<>();

    public Scoreboard(List<Player> players){
        for (Player player : players) {
            scores.put(player, 0);
        }
    }

    @Override
    public void update(Game game) {
        Player winner = game.getWinner();
        scores.put(winner, scores.get(winner) + 1);
    }

    public void printScores() {
        scores.entrySet().stream().forEach(e -> System.out.println(e.getKey().getName() + " " + e.getValue()));
    }

    public static void main(String[] args) {
        Player vishal = new Player(Symbol.X, "Vishal", 0);
        Player kanan = new Player(Symbol.O, "Kanan", 1);
        List<Player> players = List.of(vishal, kanan);

        Scoreboard scoreboard = new Scoreboard(players);

        scoreboard.printScores();
    }

}
