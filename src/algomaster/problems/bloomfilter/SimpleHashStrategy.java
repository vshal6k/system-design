package algomaster.problems.bloomfilter;

public class SimpleHashStrategy implements HashStrategy {

    @Override
    public int hash(String element, int seed, int bitArraySize) {
        int hashValue = 0;
        for (int i = 0; i < element.length(); i++) {
            hashValue = hashValue * seed + element.charAt(i);
        }
        return hashValue % bitArraySize;
    }

    public static void main(String[] args) {
        SimpleHashStrategy simpleHashStrategy = new SimpleHashStrategy();
        System.out.println(simpleHashStrategy.hash("Vishal", 0, 5));
        System.out.println(simpleHashStrategy.hash("Wow", 0, 5));
    }

}
