package algomaster.problems.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Scoreboard implements GameObserver {

    private Map<Player, Integer> scores = new HashMap<>();

    public Scoreboard(Player player1, Player player2) {
        scores.put(player1, 0);
        scores.put(player2, 0);
    }

    @Override
    public void update(Game game) {
        Player winner = game.getWinner();
        scores.put(winner, scores.get(winner) + 1);
    }

    public void printScores() {
        scores.entrySet().stream().forEach(e -> System.out.println(e));
    }

}
