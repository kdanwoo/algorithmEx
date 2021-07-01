package forkb;

public class BinarySearchTree {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    //순환적인 탐색
    public static Node circularSearch(Node node, int key){
        if(node == null)
            return null;

        if(key == node.value)
            return node;
        else if(key < node.value)
            return circularSearch(node.left, key);
        else
            return circularSearch(node.right, key);

    }

    //반복적인 탐색
    public static Node repeativeSearch(Node node, int key){
        while(node != null){
            if(key == node.value) {
                return node;
            } else if(key < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        //탐색실패시
        return null;
    }

    //노드 삽입?
    public Node insertNode(Node node, int key){
        if(node == null)
            return new Node(key);

        //그렇지 않으면 순환적으로 트리를 내려감
        if(key < node.value)
            node.left = insertNode(node.left, key);
        else
            node.right = insertNode(node.right, key);

        //삽입 완료 후, 루트 노드 반환하며 끝
        return node;
    }




    public static void main(String[] args) {

    }
}
