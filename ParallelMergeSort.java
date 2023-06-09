package mergesort;

import java.util.Arrays;

public class ParallelMergeSort implements Runnable {
    public static void sort(int [] array) {
        if (array.length > 1) {
            int [] firstHalf = Arrays.copyOf(array, array.length / 2);
            sort(firstHalf);
            int [] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
            sort(secondHalf);
            merge(firstHalf, secondHalf, array);
        }
    }

    public static void merge(int [] part1, int [] part2, int dest[]) {
        int part1Index = 0, part2Index = 0, destIndex = 0;
        while (part1Index < part1.length && part2Index < part2.length) {
            if (part1[part1Index] < part2[part2Index])
                dest[destIndex ++] = part1[part1Index ++];
            else
                dest[destIndex ++] = part2[part2Index ++];
        }
        // copy elements when at most one of the parts contains elements
        while (part1Index < part1.length)
            dest[destIndex ++] = part1[part1Index ++];
        while (part2Index < part2.length)
            dest[destIndex ++] = part2[part2Index ++];
    }
    
    public static boolean isSorted(int [] array) {
        int current = array[0];
        for (int i: array) {
            if (i < current) {
                return false;
            } else {
                current = i;
            }
        }
        return true;
    }

    @Override
    public void run() {

    }
}
