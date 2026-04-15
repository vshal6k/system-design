package algomaster.problems.snakeladder;

import java.util.Random;

public class RandomNumberProductionStrategy implements NumberProductionStrategy {

    @Override
    public int produceNumber(int range) {
        return new Random().nextInt(range) + 1;
    }

}
