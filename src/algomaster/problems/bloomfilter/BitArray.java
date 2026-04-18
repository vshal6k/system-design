package algomaster.problems.bloomfilter;

import java.util.Arrays;

public class BitArray {
    private final int size;
    private boolean[] bits;

    BitArray(int size){
        this.size = size;
        bits = new boolean[size];
    }

    void setBit(int position){
        bits[position] = true;
    }

    boolean getBit(int position){
        return bits[position];
    }

    public static void main(String[] args) {
        BitArray bitArray = new BitArray(10);

        bitArray.setBit(1);

        for (boolean bit : bitArray.bits) {
            System.out.print(bit + " ");
        }
        System.out.println();

        System.out.println(bitArray.getBit(1));
    }

    public void clear() {
        Arrays.fill(bits, false);
    }

}
