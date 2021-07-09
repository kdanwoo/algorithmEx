package forbs.real;

//노드경로 가장 작은 최소값
public class ShortPathBST {

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

    static class Solution{
        int min = Integer.MAX_VALUE;
        Node prev = null;

        public int diffBST(Node root){
            inorder(root);

            return min;
        }

        private void inorder(Node node) {
            if(node==null){
                return;
            }

            inorder(node.left);

            if(prev != null){
                int curl = node.data - prev.data;
                min = (min > curl) ? curl : min;
            }

            prev = node;

            inorder(node.right);

        }
    }

    public static void main(String[] args) {
        //@Test
        Node rootA = new Node(10);
        rootA.left = new Node(5);
        rootA.right = new Node(5);
        rootA.left.right = new Node(2);
        rootA.right.right = new Node(1);
        rootA.right.right.left = new Node(-1);

        Solution solution = new Solution();

        System.out.println(solution.diffBST(rootA));

    }
}
