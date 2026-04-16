package algomaster.problems.snakeladder;

public class Dice {
    private int range;
    private NumberProductionStrategy numberProductionStrategy;

    public Dice(int range, NumberProductionStrategy numberProductionStrategy) {
        this.range = range;
        this.numberProductionStrategy = numberProductionStrategy;
    }

    public int produceNumber(){
        return this.numberProductionStrategy.produceNumber(range);
    }

    public int getRange() {
        return range;
    }

    public static void main(String[] args) {
        Dice dice = new Dice(6, new RandomNumberProductionStrategy());
        System.out.println(dice.produceNumber());
        System.out.println(dice.produceNumber());
        System.out.println(dice.produceNumber());
        System.out.println(dice.produceNumber());
    }
}
