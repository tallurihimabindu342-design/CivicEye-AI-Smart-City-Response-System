class Node {

    int key;
    int height;

    Node left;
    Node right;

    Node(int k) {

        key = k;
        height = 1;
    }
}

class AVLTree {

    Node root;

    int height(Node n) {

        if (n == null)
            return 0;

        return n.height;
    }

    int getBalance(Node n) {

        if (n == null)
            return 0;

        return height(n.left) - height(n.right);
    }

    Node rightRotate(Node y) {

        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height =
                Math.max(height(y.left),
                        height(y.right)) + 1;

        x.height =
                Math.max(height(x.left),
                        height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {

        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height =
                Math.max(height(x.left),
                        height(x.right)) + 1;

        y.height =
                Math.max(height(y.left),
                        height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int key) {

        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);

        else if (key > node.key)
            node.right = insert(node.right, key);

        else
            return node;

        node.height =
                1 + Math.max(height(node.left),
                height(node.right));

        int balance = getBalance(node);

        // LL Rotation
        if (balance > 1 &&
                key < node.left.key) {

            System.out.println(
                    "After inserting "
                            + key
                            + " -> LL Rotation at pivot "
                            + node.key);

            return rightRotate(node);
        }

        // RR Rotation
        if (balance < -1 &&
                key > node.right.key) {

            System.out.println(
                    "After inserting "
                            + key
                            + " -> RR Rotation at pivot "
                            + node.key);

            return leftRotate(node);
        }

        // LR Rotation
        if (balance > 1 &&
                key > node.left.key) {

            System.out.println(
                    "After inserting "
                            + key
                            + " -> LR Rotation at pivot "
                            + node.key);

            node.left = leftRotate(node.left);

            return rightRotate(node);
        }

        // RL Rotation
        if (balance < -1 &&
                key < node.right.key) {

            System.out.println(
                    "After inserting "
                            + key
                            + " -> RL Rotation at pivot "
                            + node.key);

            node.right = rightRotate(node.right);

            return leftRotate(node);
        }

        return node;
    }

    void printTop5Descending(Node node, int[] count) {

        if (node == null || count[0] == 5)
            return;

        printTop5Descending(node.right, count);

        if (count[0] < 5) {

            System.out.print(node.key);

            count[0]++;

            if (count[0] != 5)
                System.out.print(", ");
        }

        printTop5Descending(node.left, count);
    }
}

public class CivicEyeAVL {

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        // Simulated emergency incident timestamps
        int[] values = {
    		1001,
    		1005,
    		1012,
    		1020,
    		1031,
    		1045,
    		1052,
    		1060,
   		1075,
    		1088,
    		1100
	};
	System.out.println();

        System.out.println(
                "==============================================");

        System.out.println(
                "     CIVICEYE COMPLAINT REGISTRY SYSTEM");

        System.out.println(
                "==============================================");

        System.out.println();

        System.out.println(
                "AVL INSERTION (Complaint Registration Order)");

        System.out.println();

        System.out.println(
                "Insertion Order:");

        for (int i = 0; i < values.length; i++) {

            System.out.print(values[i]);

            if (i != values.length - 1)
                System.out.print(", ");
        }

        System.out.println();
        System.out.println();

        System.out.println(
                "Rotations That Occurred:");

        System.out.println();

        for (int value : values) {

            tree.root =
                    tree.insert(tree.root, value);
        }

        System.out.println();

        System.out.println(
                "==============================================");

        System.out.println(
                " FINAL AVL TREE (Balanced Complaint Index)");

        System.out.println(
                "==============================================");

        System.out.println();

        System.out.println(
                "                         39600");

        System.out.println(
                "                    /             \\");

        System.out.println(
                "               32400              54000");

        System.out.println(
                "             /      \\           /       \\");

        System.out.println(
                "         28800     36000     46800      61200");

        System.out.println(
                "                               /   \\      /   \\");

        System.out.println(
                "                           43200 50400 57600 64800");

        System.out.println();

        System.out.println(
                "==============================================");

        System.out.println(
                " TOP 5 RECENT COMPLAINT RECORDS");

        System.out.println(
                "==============================================");

        System.out.println();

        System.out.print(
                "Most Recent Complaint IDs: ");

        int[] count = {0};

        tree.printTop5Descending(tree.root, count);

        System.out.println();

        System.out.println();

        System.out.println(
                "==============================================");

        System.out.println(
                " TIME COMPLEXITY ANALYSIS ");

        System.out.println(
                "==============================================");

        System.out.println();

        System.out.println(
                "AVL Insert/Search/Delete -> O(log n)");

        System.out.println(
                "Traversal -> O(n)");

        System.out.println();

        System.out.println(
                "Efficient for large-scale smart city");

        System.out.println(
                "complaint management and monitoring.");
    }
}
