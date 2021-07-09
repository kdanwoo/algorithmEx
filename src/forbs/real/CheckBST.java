package forbs.real;

// Java program to check if a given tree is BST.
class CheckBST
{
    /* A binary tree node has data, pointer to
    left child and a pointer to right child */
    static class Node
    {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    };
    static Node prev;
    static boolean isBSTUtil(Node root)
    {
        // traverse the tree in inorder fashion and
        // keep track of prev node
        if (root != null)
        {
            if (!isBSTUtil(root.left))
                return false;
            // Allows only distinct valued nodes
            if (prev != null && root.data <= prev.data)
                return false;
            prev = root;
            return isBSTUtil(root.right);
        }
        return true;
    }
    static boolean isBST(Node root)
    {
        return isBSTUtil(root);
    }
    // Driver Code
    public static void main(String[] args)
    {
        //@Test
        Node rootA = new Node(1);
        rootA.left = new Node(2);
        rootA.right = new Node(3);
        rootA.left.left = new Node(4);
        rootA.left.right = new Node(5);
        rootA.right.left = new Node(6);
        rootA.right.right = new Node(7);

        // @Test
        Node rootB = new Node(4);
        rootB.left = new Node(2);
        rootB.right = new Node(6);
        rootB.left.left = new Node(1);
        rootB.left.right = new Node(3);
        rootB.right.left = new Node(5);
        rootB.right.right = new Node(7);

        //@Test
        Node rootC = new Node(5);
        rootB.left = new Node(3);
        rootB.right = new Node(7);


        if (isBST(rootC))
            System.out.println(" Is BST");
        else
            System.out.println(" Not a BST");

//        if (isBST(rootA))
//            System.out.println("rootA Is BST");
//        else
//            System.out.println("rootA Not a BST");

    }
} 