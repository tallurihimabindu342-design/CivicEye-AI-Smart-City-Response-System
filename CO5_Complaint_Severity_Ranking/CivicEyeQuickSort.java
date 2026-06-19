import java.util.*;

public class CivicEyeQuickSort {

    static void quickSort(int[] arr,
                          int low,
                          int high) {

        if (low < high) {

            int pivotIndex =
                    partition(arr,
                            low,
                            high);

            quickSort(arr,
                    low,
                    pivotIndex - 1);

            quickSort(arr,
                    pivotIndex + 1,
                    high);
        }
    }

    static int partition(int[] arr,
                         int low,
                         int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low;
             j < high;
             j++) {

            if (arr[j] < pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] severity = {
                5,
                2,
                4,
                1,
                3
        };

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "   CIVICEYE COMPLAINT SEVERITY RANKING");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "UNSORTED COMPLAINT SEVERITY DATA");

        System.out.println();

        for (int i = 0;
             i < severity.length;
             i++) {

            System.out.println(
                    "Zone "
                            + i
                            + " -> Severity "
                            + severity[i]);
        }

        System.out.println();

        System.out.println(
                "Running Quick Sort...");

        System.out.println();

        quickSort(severity,
                0,
                severity.length - 1);

        System.out.println(
                "===================================================");

        System.out.println(
                "      SORTED COMPLAINT PRIORITIES");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Severity Levels:");

        System.out.println();

        for (int value : severity) {

            System.out.print(
                    value + " ");
        }

        System.out.println();

        System.out.println();

        System.out.println(
                "Highest Priority Complaint = Severity "
                        + severity[severity.length - 1]);

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "     QUICK SORT VISUALIZATION");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Initial Array:");

        System.out.println(
                "[5, 2, 4, 1, 3]");

        System.out.println();

        System.out.println(
                "After Quick Sort:");

        System.out.println(
                "[1, 2, 3, 4, 5]");

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "      TIME COMPLEXITY ANALYSIS");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Best Case -> O(n log n)");

        System.out.println(
                "Average Case -> O(n log n)");

        System.out.println(
                "Worst Case -> O(n²)");

        System.out.println(
                "Space Complexity -> O(log n)");

        System.out.println();

        System.out.println(
                "Efficient for complaint ranking");

        System.out.println(
                "and emergency prioritization.");
    }
}
