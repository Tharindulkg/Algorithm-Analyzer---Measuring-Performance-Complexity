//import java.utill.Random:

import java.util.Random;

public class QuickSortAnalyzer {

    public static void quickSort(int[] arr, int low, int high) {
        if (low< high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi +1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j< high; j++){
            if (arr[j]< pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;     
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    public static int[] generateRandomArray(int size){
        Random rand = new Random();
        int[] arr = new int[size];
        for(int i = 0; i< size; i++)
            arr[i] = rand.nextInt(10000);
        return arr;
    }


    public static void main (String[] args) {
        int[] sizes = {100, 500, 1000, 2000, 5000, };

        System.out.println("                        ");
        System.out.println(" ALGORITHM : QUICK SORT ");
        System.out.println("------------------------");
        System.out.println("Input Size  |  Time (ms)");
        System.out.println("------------------------");

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            long start = System.nanoTime();
            quickSort(arr, 0, arr.length - 1);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f\n", size, timeMs);
        }


    }
}