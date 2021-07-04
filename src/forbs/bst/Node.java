package forbs.bst;

/**
 * 먼저 노드(Node)를 나타낼 클래스를 정의한다. 노드의 값(Value)을 나타내는 멤버 변수와 왼쪽과 오른쪽 자식 노드는 생성자로 초기화하면 된다.
 * */
public class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}
