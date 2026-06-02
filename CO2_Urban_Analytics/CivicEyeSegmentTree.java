class SegmentTree {

    int[] tree;
    int[] complaints;
    int n;

    SegmentTree(int[] arr) {

        complaints = arr;
        n = arr.length;

        tree = new int[4 * n];

        build(0, 0, n - 1);
    }

    void build(int node, int start, int end) {

        if (start == end) {

            tree[node] = complaints[start];
        }

        else {

            int mid = (start + end) / 2;

            build(2 * node + 1, start, mid);

            build(2 * node + 2, mid + 1, end);

            tree[node] =
                    tree[2 * node + 1]
                            + tree[2 * node + 2];
        }
    }

    int query(int node,
              int start,
              int end,
              int left,
              int right) {

        if (right < start || end < left)
            return 0;

        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;

        int p1 =
                query(2 * node + 1,
                        start,
                        mid,
                        left,
                        right);

        int p2 =
                query(2 * node + 2,
                        mid + 1,
                        end,
                        left,
                        right);

        return p1 + p2;
    }

    int getMaxComplaintZone() {

        int max = complaints[0];
        int zone = 0;

        for (int i = 1; i < complaints.length; i++) {

            if (complaints[i] > max) {

                max = complaints[i];
                zone = i;
            }
        }

        return zone;
    }
}

public class CivicEyeSegmentTree {

    public static void main(String[] args) {

        // Simulated citizen complaint data

        int[] complaints = {

                18, // Zone 0
                25, // Zone 1
                12, // Zone 2
                31, // Zone 3
                40, // Zone 4
                22, // Zone 5
                15  // Zone 6
        };

        SegmentTree st =
                new SegmentTree(complaints);

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "     CIVICEYE COMPLAINT ANALYTICS ENGINE");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "REAL-TIME COMPLAINT DENSITY DATA");

        System.out.println();

        for (int i = 0; i < complaints.length; i++) {

            System.out.println(
                    "Zone "
                            + i
                            + " -> "
                            + complaints[i]
                            + " complaints");
        }

        System.out.println();

        System.out.println(
                "Building Segment Tree for Complaint Analytics...");

        System.out.println();

        int left = 1;
        int right = 4;

        int total =
                st.query(
                        0,
                        0,
                        complaints.length - 1,
                        left,
                        right);

        System.out.println(
                "===================================================");

        System.out.println(
                "         COMPLAINT RANGE QUERY ANALYSIS");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Query Range:");

        System.out.println(
                "Zone "
                        + left
                        + " to Zone "
                        + right);

        System.out.println();

        System.out.println(
                "Complaint Calculation:");

        System.out.println(
                "25 + 12 + 31 + 40");

        System.out.println();

        System.out.println(
                "Total Complaints = "
                        + total);

        System.out.println();

        int hotspot =
                st.getMaxComplaintZone();

        System.out.println(
                "===================================================");

        System.out.println(
                "            HOTSPOT DETECTION");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Zone "
                        + hotspot
                        + " has the highest complaint density.");

        System.out.println(
                "Complaint Monitoring Alert Generated.");

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "         SEGMENT TREE VISUALIZATION");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "                     163");

        System.out.println(
                "                 /         \\");

        System.out.println(
                "              86             77");

        System.out.println(
                "            /    \\         /    \\");

        System.out.println(
                "          43      43      62     15");

        System.out.println(
                "         / \\     /  \\    /  \\");

        System.out.println(
                "       18  25  12  31  40  22");

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "         TIME COMPLEXITY ANALYSIS");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Segment Tree Build -> O(n)");

        System.out.println(
                "Range Query -> O(log n)");

        System.out.println(
                "Update Operation -> O(log n)");

        System.out.println(
                "Hotspot Detection -> O(n)");

        System.out.println(
                "Space Complexity -> O(4n)");

        System.out.println();

        System.out.println(
                "Efficient for real-time smart city");

        System.out.println(
                "complaint analytics and hotspot monitoring.");
    }
}
