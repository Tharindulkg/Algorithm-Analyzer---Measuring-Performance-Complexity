import java.util.Arrays;
import java.util.Random;

public class BinarySearchAnalyzer {

    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
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
        int[] sizes = {100, 500, 1000,2000, 5000};

        System.out.println("Algorithm: Binary Search");
        System.out.println("----------------------");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            Arrays.sort(arr);
            int key = arr[size / 2];

            long start = System.nanoTime();
            binarySearch(arr, key);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f\n", size, timeMs);
        }
    }
}
