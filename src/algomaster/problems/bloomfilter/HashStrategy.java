package algomaster.problems.bloomfilter;

public interface HashStrategy {
    int hash(String element, int seed, int bitArraySize);
}
