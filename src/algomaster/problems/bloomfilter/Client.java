package algomaster.problems.bloomfilter;

public class Client {
    public static void main(String[] args) {
        BloomFilter.Builder builder = new BloomFilter.Builder(1000);
        builder.falsePositiveRate(0.002);

        BloomFilter bloomFilter = builder.build();

        bloomFilter.add("Vishal");
        bloomFilter.add("Kanan");
        bloomFilter.add("Het");

        System.out.println(bloomFilter.mightContain("Vishal"));
        System.out.println(bloomFilter.mightContain("Kanan"));
        System.out.println(bloomFilter.mightContain("Het"));

        System.out.println(bloomFilter.mightContain("Soumya"));
        System.out.println(bloomFilter.mightContain("Apeksha"));
        System.out.println(bloomFilter.mightContain("Vaidehi"));

        System.out.println("==========================");
        System.out.println("Resetting Bloom Filter");
        System.out.println("==========================");
        bloomFilter.clear();

        System.out.println(bloomFilter.mightContain("Vishal"));
        System.out.println(bloomFilter.mightContain("Kanan"));
        System.out.println(bloomFilter.mightContain("Het"));

        System.out.println(bloomFilter.mightContain("Soumya"));
        System.out.println(bloomFilter.mightContain("Apeksha"));
        System.out.println(bloomFilter.mightContain("Vaidehi"));
    }
}
