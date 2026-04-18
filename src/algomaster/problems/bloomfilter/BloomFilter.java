package algomaster.problems.bloomfilter;

public class BloomFilter {
    private final BloomFilterConfig config;
    private HashStrategy hashStrategy;
    private BitArray bits;

    private BloomFilter(Builder builder) {
        this.config = builder.config;
        this.hashStrategy = builder.hashStrategy;
        this.bits = builder.bits;
    }

    public synchronized void add(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        int hashFunctionsRequired = config.getHashFunctionsRequired();
        int bitArraySize = config.getBitArraySize();
        for (int seed = 0; seed < hashFunctionsRequired; seed++) {
            bits.setBit(hashStrategy.hash(element, seed, bitArraySize));
        }
    }

    public synchronized boolean mightContain(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        int hashFunctionsRequired = config.getHashFunctionsRequired();
        int bitArraySize = config.getBitArraySize();
        for (int seed = 0; seed < hashFunctionsRequired; seed++) {
            if (!bits.getBit(hashStrategy.hash(element, seed, bitArraySize)))
                return false;

        }
        return true;
    }

    public synchronized void clear() {
        bits.clear();
    }

    public static class Builder {
        private HashStrategy hashStrategy = new SimpleHashStrategy();
        private double falsePositiveRate = 0.001;
        private int expectedSize;
        private BitArray bits;
        private BloomFilterConfig config;

        public Builder(int expectedSize) {
            this.expectedSize = expectedSize;
        }

        public Builder hashStrategy(HashStrategy hashStrategy) {
            this.hashStrategy = hashStrategy;
            return this;
        }

        public Builder falsePositiveRate(double falsePositiveRate) {
            this.falsePositiveRate = falsePositiveRate;
            return this;
        }

        public BloomFilter build() {
            if (falsePositiveRate >= 1 || falsePositiveRate <= 0)
                throw new IllegalArgumentException("False positive rate should be between 0 and 1");

            if(expectedSize <= 0)
                throw new IllegalArgumentException("Expected size must be positive");

            if(hashStrategy == null)
                throw new IllegalArgumentException("Hash strategy cannot be null");

            config = new BloomFilterConfig(expectedSize, falsePositiveRate);
            bits = new BitArray(config.getBitArraySize());
            return new BloomFilter(this);
        }
    }

}
