import java.util.Random;

public class LinerSearchAnalyzer {

    public static int LinerSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(10000);
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            int key = arr[size / 2];

            long start = System.nanoTime();
            LinerSearch(arr, key);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f\n", size, timeMs);
        }
    }
}
