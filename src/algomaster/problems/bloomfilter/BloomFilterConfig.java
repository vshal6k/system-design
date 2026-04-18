package algomaster.problems.bloomfilter;

public class BloomFilterConfig {
    private final int expectedSize;
    public int getExpectedSize() {
        return expectedSize;
    }

    public double getFalsePositiveRate() {
        return falsePositiveRate;
    }

    public int getBitArraySize() {
        return bitArraySize;
    }

    public int getHashFunctionsRequired() {
        return hashFunctionsRequired;
    }

    private final double falsePositiveRate;
    private final int bitArraySize;
    private final int hashFunctionsRequired;

    public BloomFilterConfig(int expectedSize, double falsePositiveRate){
        this.expectedSize = expectedSize;
        this.falsePositiveRate = falsePositiveRate;
        this.bitArraySize = derivebitArraySize(expectedSize, falsePositiveRate);
        this.hashFunctionsRequired = deriveHashFunctionsRequired(expectedSize, this.bitArraySize);
    }

    // Bit array size: m = -(n * ln(p)) / (ln(2))^2
    private int derivebitArraySize(int expectedSize, double falsePositiveRate){
        double log2 = Math.log(2);
        return (int)Math.ceil((-1 * (expectedSize * Math.log(falsePositiveRate))) / (Math.pow(log2, 2)));
    }

    // Number of hash functions: k = (m / n) * ln(2)
    private int deriveHashFunctionsRequired(int expectedSize, int bitArraySize){
        double log2 = Math.log(2);
        return (int)Math.ceil(((bitArraySize* 1.0) /expectedSize) * log2);
    }
    
    // @Override
    // public String toString() {
    //     return "BloomFilterConfig [expectedSize=" + expectedSize + ", falsePositiveRate=" + falsePositiveRate
    //             + ", bitArraySize=" + bitArraySize + ", hashFunctionsRequired=" + hashFunctionsRequired + "]";
    // }

    public static void main(String[] args) {
        BloomFilterConfig bloomFilterConfig = new BloomFilterConfig(100, 0.00001);
        // System.out.println(bloomFilterConfig.toString());
    }

}
