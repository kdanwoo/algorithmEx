package forbs.bst;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insertNode(15);
        binaryTree.insertNode(20);
        binaryTree.insertNode(25);
        binaryTree.insertNode(30);
        binaryTree.insertNode(50);
        binaryTree.insertNode(40);
        binaryTree.insertNode(38);
        binaryTree.insertNode(46);
        binaryTree.insertNode(56);
        binaryTree.insertNode(53);
        binaryTree.insertNode(51);
        binaryTree.insertNode(55);
        binaryTree.insertNode(57);

        binaryTree.inOrderTraverse(binaryTree.rootNode);

        if (binaryTree.deleteNode(30)) {
            System.out.println("노드 삭제");
        }


        binaryTree.inOrderTraverse(binaryTree.rootNode);
    }
}

