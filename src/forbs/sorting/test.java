package forbs.sorting;

// Java program to find maximum sum leaf to root
// path in Binary Tree

// A Binary Tree node
class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Minimum {
    int min_no = Integer.MAX_VALUE;
}

class BinaryTree {
    Node root;
    Minimum min = new Minimum();
    Node target_leaf = null;

    //root에서 target_leaf까지의 경로에 있는 모든 노드를 인쇄하는 유틸리티 함수
    boolean printPath(Node node, Node target_leaf)
    {
        // base case
        if (node == null)
            return false;

        //이 노드가 target_leaf이거나 하위 노드 중 하나에 대상 리프인 경우 true 반환
        if (node == target_leaf || printPath(node.left, target_leaf)
                || printPath(node.right, target_leaf)) {
            System.out.print(node.data + " ");
            return true;
        }

        return false;
    }

    //이 함수는 target_leaf_ref가 최대 경로 합계의 리프 노드를 참조하도록 설정합니다. 또한 max_sum_ref를 사용하여 max_sum을 반환합니다.
    void getTargetLeaf(Node node, Minimum min_sum_ref, int curr_sum)
    {
        if (node == null)
            return;

        curr_sum = curr_sum + node.data;

        //리프 노드이고 이 노드에 대한 경로의 합계가 지금까지 최대인 경우 이 노드를 target_leaf로 만드십시오
        if (node.left == null && node.right == null) {
            if (curr_sum < min_sum_ref.min_no) {
                min_sum_ref.min_no = curr_sum;
                target_leaf = node;
            }
        }

        //리프 노드가 아닌 경우 target_leaf를 찾기 위해 다시 아래로 이동합니다.
        getTargetLeaf(node.left, min_sum_ref, curr_sum);
        getTargetLeaf(node.right, min_sum_ref, curr_sum);
    }

    //최대 합계를 반환하고 최대 합계 경로에 노드를 인쇄합니다.
    int maxSumPath()
    {
        // base case
        if (root == null)
            return 0;

        // find the target leaf and maximum sum
        getTargetLeaf(root, min, 0);

        // print the path from root to the target leaf
        printPath(root, target_leaf);
        return min.min_no; // return maximum sum
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        int sum = tree.maxSumPath();
        System.out.println("");
        System.out.println("Sum of nodes is : " + sum);
    }
}