import java.util.*;

public class CivicEyeGraph {

    static final int V = 6;

    int minKey(int[] key,
               boolean[] mstSet) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {

            if (!mstSet[v] &&
                    key[v] < min) {

                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    void printMST(int[] parent,
                  int[][] graph) {

        int totalCost = 0;

        System.out.println(
                "===================================================");

        System.out.println(
                "     MINIMUM SPANNING TREE (MST)");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Selected Smart City Network Connections:");

        System.out.println();

        for (int i = 1; i < V; i++) {

            System.out.println(
                    "Zone "
                            + parent[i]
                            + " ---> Zone "
                            + i
                            + "    Cost = "
                            + graph[i][parent[i]]);

            totalCost += graph[i][parent[i]];
        }

        System.out.println();

        System.out.println(
                "Total Smart City Network Cost = "
                        + totalCost);
    }

    void primMST(int[][] graph) {

        int[] parent = new int[V];

        int[] key = new int[V];

        boolean[] mstSet =
                new boolean[V];

        for (int i = 0; i < V; i++) {

            key[i] = Integer.MAX_VALUE;

            mstSet[i] = false;
        }

        key[0] = 0;

        parent[0] = -1;

        for (int count = 0;
             count < V - 1;
             count++) {

            int u =
                    minKey(key, mstSet);

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {

                if (graph[u][v] != 0 &&
                        !mstSet[v] &&
                        graph[u][v] < key[v]) {

                    parent[v] = u;

                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {

        CivicEyeGraph mst =
                new CivicEyeGraph();

        // Smart City Monitoring Network

        int[][] graph = {

                {0, 4, 2, 0, 0, 0},

                {4, 0, 1, 5, 0, 0},

                {2, 1, 0, 8, 10, 0},

                {0, 5, 8, 0, 2, 6},

                {0, 0, 10, 2, 0, 3},

                {0, 0, 0, 6, 3, 0}
        };

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "   CIVICEYE SMART CITY MONITORING NETWORK");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "SMART CITY MONITORING ZONES");

        System.out.println();

        System.out.println(
                "Zone 0 -> Complaint Management Center");

        System.out.println(
                "Zone 1 -> Traffic Monitoring Unit");

        System.out.println(
                "Zone 2 -> CCTV Surveillance Hub");

        System.out.println(
                "Zone 3 -> Public Safety Control Center");

        System.out.println(
                "Zone 4 -> Emergency Response Station");

        System.out.println(
                "Zone 5 -> Smart City Operations Center");

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "   SMART CITY MONITORING NETWORK GRAPH");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "               (0)");

        System.out.println(
                "              /   \\");

        System.out.println(
                "           4 /     \\ 2");

        System.out.println(
                "            /       \\");

        System.out.println(
                "          (1)---1---(2)");

        System.out.println(
                "           | \\       |\\");

        System.out.println(
                "         5 |  \\8     | \\10");

        System.out.println(
                "           |   \\     |");

        System.out.println(
                "          (3)---2---(4)");

        System.out.println(
                "             \\6     /3");

        System.out.println(
                "              \\    /");

        System.out.println(
                "               (5)");

        System.out.println();

        System.out.println(
                "Running Prim's Algorithm for");

        System.out.println(
                "Smart City Network Optimization...");

        System.out.println();

        mst.primMST(graph);

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "        TIME COMPLEXITY ANALYSIS");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Prim's Algorithm -> O(V²)");

        System.out.println(
                "Space Complexity -> O(V²)");

        System.out.println();

        System.out.println(
                "Efficient for smart city monitoring");

        System.out.println(
                "network optimization,");

        System.out.println(
                "resource coordination, and");

        System.out.println(
                "infrastructure planning.");
    }
}
