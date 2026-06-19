import java.util.*;

class Edge {

    int destination;
    int weight;

    Edge(int destination, int weight) {

        this.destination = destination;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {

    int vertex;
    int distance;

    Node(int vertex, int distance) {

        this.vertex = vertex;
        this.distance = distance;
    }

    public int compareTo(Node other) {

        return this.distance - other.distance;
    }
}

public class CivicEyeDijkstra {

    static ArrayList<ArrayList<Edge>> graph =
            new ArrayList<>();

    static int[] parent;

    static void addEdge(int source,
                        int destination,
                        int weight) {

        graph.get(source).add(
                new Edge(destination, weight));

        graph.get(destination).add(
                new Edge(source, weight));
    }

    static void printPath(int destination) {

        if (destination == -1)
            return;

        printPath(parent[destination]);

        if (parent[destination] != -1)
            System.out.print(" -> ");

        System.out.print("Zone " + destination);
    }

    static void dijkstra(int source,
                         int vertices) {

        PriorityQueue<Node> pq =
                new PriorityQueue<>();

        int[] distance =
                new int[vertices];

        parent =
                new int[vertices];

        Arrays.fill(distance,
                Integer.MAX_VALUE);

        Arrays.fill(parent,
                -1);

        distance[source] = 0;

        pq.add(
                new Node(source, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            int u = current.vertex;

            for (Edge edge :
                    graph.get(u)) {

                int v = edge.destination;

                int newDistance =
                        distance[u] + edge.weight;

                if (newDistance < distance[v]) {

                    distance[v] =
                            newDistance;

                    parent[v] = u;

                    pq.add(
                            new Node(v,
                                    newDistance));
                }
            }
        }

        System.out.println(
                "===================================================");

        System.out.println(
                "     SHORTEST PATH ANALYSIS");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Control Center Location : Zone 0");

        System.out.println(
                "Emergency Location      : Zone 5");

        System.out.println();

        System.out.println(
                "Fastest Route:");

        printPath(5);

        System.out.println();

        System.out.println();

        System.out.println(
                "Total Response Time = "
                        + distance[5]
                        + " Minutes");
    }

    public static void main(String[] args) {

        int vertices = 6;

        for (int i = 0;
             i < vertices;
             i++) {

            graph.add(
                    new ArrayList<>());
        }

        addEdge(0, 1, 4);
        addEdge(0, 2, 2);
        addEdge(1, 3, 5);
        addEdge(2, 3, 1);
        addEdge(2, 4, 7);
        addEdge(3, 5, 6);
        addEdge(4, 5, 3);

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "   CIVICEYE EMERGENCY ROUTE OPTIMIZATION");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "SMART CITY ROAD NETWORK");

        System.out.println();

        System.out.println(
                "Zone 0 -> Emergency Control Center");

        System.out.println(
                "Zone 1 -> Traffic Monitoring Unit");

        System.out.println(
                "Zone 2 -> Ambulance Dispatch Center");

        System.out.println(
                "Zone 3 -> Fire Response Station");

        System.out.println(
                "Zone 4 -> Medical Support Center");

        System.out.println(
                "Zone 5 -> Emergency Incident Location");

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "     CITY ROAD NETWORK GRAPH");

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
                "          (1)---5---(3)");

        System.out.println(
                "                   /");

        System.out.println(
                "                 1/");

        System.out.println(
                "                 /");

        System.out.println(
                "               (2)---7---(4)");

        System.out.println(
                "                       \\");

        System.out.println(
                "                        3");

        System.out.println(
                "                         \\");

        System.out.println(
                "                         (5)");

        System.out.println();

        System.out.println(
                "Running Dijkstra Algorithm...");

        System.out.println();

        dijkstra(0, vertices);

        System.out.println();

        System.out.println(
                "===================================================");

        System.out.println(
                "     TIME COMPLEXITY ANALYSIS");

        System.out.println(
                "===================================================");

        System.out.println();

        System.out.println(
                "Dijkstra Algorithm -> O((V + E) log V)");

        System.out.println(
                "Priority Queue Operations -> O(log V)");

        System.out.println(
                "Graph Traversal -> O(V + E)");

        System.out.println(
                "Space Complexity -> O(V + E)");

        System.out.println();

        System.out.println(
                "Efficient for smart city emergency");

        System.out.println(
                "route optimization and");

        System.out.println(
                "response planning.");
    }
}
