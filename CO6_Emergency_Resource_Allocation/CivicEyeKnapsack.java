public class CivicEyeKnapsack {

    static int knapsack(int capacity,
                        int[] weights,
                        int[] values,
                        int n) {

        int[][] dp =
                new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {

            for (int w = 0;
                 w <= capacity;
                 w++) {

                if (i == 0 || w == 0) {

                    dp[i][w] = 0;
                }

                else if (weights[i - 1] <= w) {

                    dp[i][w] =
                            Math.max(
                                    values[i - 1]
                                            + dp[i - 1][w - weights[i - 1]],

                                    dp[i - 1][w]);
                }

                else {

                    dp[i][w] =
                            dp[i - 1][w];
                }
            }
        }

        System.out.println();

        System.out.println(
                "Selected Resources:");

        int result =
                dp[n][capacity];

        int w = capacity;

        for (int i = n;
             i > 0 && result > 0;
             i--) {

            if (result != dp[i - 1][w]) {

                System.out.println(
                        resourceNames[i - 1]);

                result =
                        result - values[i - 1];

                w =
                        w - weights[i - 1];
            }
        }

        return dp[n][capacity];
    }

    static String[] resourceNames = {

            "Medical Kit",
            "Oxygen Cylinder",
            "Rescue Toolkit"
    };

    public static void main(String[] args) {

        int[] weights = {

                5,
                4,
                6
        };

        int[] values = {

                10,
                8,
                12
        };

        int capacity = 11;

        int n =
                values.length;

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "   CIVICEYE EMERGENCY RESOURCE ALLOCATION");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "AVAILABLE RESOURCES");

        System.out.println();

        System.out.println(
                "Medical Kit        Weight = 5   Value = 10");

        System.out.println(
                "Oxygen Cylinder    Weight = 4   Value = 8");

        System.out.println(
                "Rescue Toolkit     Weight = 6   Value = 12");

        System.out.println();

        System.out.println(
                "Vehicle Capacity = "
                        + capacity);

        System.out.println();

        System.out.println(
                "Running 0/1 Knapsack Algorithm...");

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "       OPTIMAL RESOURCE SELECTION");

        System.out.println(
                "===================================================");

        int maxUtility =
                knapsack(
                        capacity,
                        weights,
                        values,
                        n);

        System.out.println();

        System.out.println(
                "Maximum Utility = "
                        + maxUtility);

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "      KNAPSACK VISUALIZATION");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Vehicle Capacity = 11");

        System.out.println();

        System.out.println(
                "Selected:");

        System.out.println(
                "[Medical Kit]");

        System.out.println(
                "[Rescue Toolkit]");

        System.out.println();

        System.out.println(
                "Total Weight = 11");

        System.out.println(
                "Total Value = 22");

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "      TIME COMPLEXITY ANALYSIS");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Dynamic Programming -> O(nW)");

        System.out.println(
                "Resource Selection -> O(n)");

        System.out.println(
                "Space Complexity -> O(nW)");

        System.out.println();

        System.out.println(
                "Efficient for emergency");

        System.out.println(
                "resource allocation and");

        System.out.println(
                "disaster response planning.");
    }
}
