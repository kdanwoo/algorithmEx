package forbs.real;

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

/**
 * 이제 이진 탐색 트리를 구현해보자. 기본적으로 삽입과 삭제 연산을 가지고 있고
 * 트리의 탐색은 전위(pre-order), 후위(post-order) 그리고 중위(in-order) 순회가 있다.
 * 트리가 존재하는지 확인이 필요하다.
 * */
class BinaryTree{

    //root노드를 null로 초기화 시킨다
    Node rootNode = null;

    public Node findNode(int key){
        //루트가 null이면 존재하지 않기 때문에!
       if(rootNode == null){
           return null;
       }
        Node focusNode = rootNode; //탐색용 노드

        while(focusNode.value != key){
            if(key < focusNode.value){ //현재노드보다 작으면
                focusNode = focusNode.left; //현재 노드의 왼쪽 자식노드로
            }else{
                focusNode = focusNode.right; //현재노드보다 크면 노드의 오른쪽 자식노드를 가리킨다
            }

            if(focusNode == null){
                return null;
            }
        }

        return focusNode;
    }

    //노드 삽입
    public void insert(int key){

        if (findNode(key) != null) return;  // 이미 존재하면 그냥 리턴

        Node newNode = new Node(key); //존재하지 않으니까 새로운 노드를 생성해줌!

        if(rootNode == null) { //root가 Null이면 root에 새로운 노드 생성
            rootNode = newNode;
        }else{
            Node focusNode = rootNode;  //  탐색용 노드
            Node parent;            //  탐색용 노드의 부모

            while(true){
                parent = focusNode; // 이동하기위해 현재노드의 부모노드에 현재 노드를 넣어줌.

                if(key < parent.value){ //들어온 키가 현재노드보다 작다면 -> 왼쪽으로 이동
                    focusNode = parent.left;
                    if (focusNode == null) {        //  왼쪽 노드가 비어있으면
                        parent.left = newNode; //  왼쪽 노드에 삽입
                        return;
                    }
                }else{
                    focusNode = parent.right;
                    if(focusNode == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }

        }
    }

    /**
     * 특정 노드 삭제
     * 삭제하려는 노드의 자식이 없는 경우
     * 삭제하려는 노드의 자식이 하나만 있는 경우
     * 삭제하려는 노드의 자식이 둘 다 있는 경우
     * 각각의 경우에서 공통점을 살펴보면, 세 가지 모든 경우에서 삭제하려는 노드의 부모노드를 기억하고 있어야 한다.
     * 삭제하려는 노드가 부모노드를 기준으로 왼쪽 자식노드인지 오른쪽 자식노드인지 알아야 한다.
     */
    public boolean delete(int key){
        // focusNode 와 parent 가 같을 수 있는 경우는 찾으려는 key 가 root 인 경우
        Node focusNode = rootNode;
        Node parent = rootNode;

        boolean isLeftChild = true; //왼쪽노드인지 아닌지를 체크해야함

        // while 문이 끝나고 나면 focusNode 는 삭제될 노드를 가리키고,
        // parent 는 삭제될 노드의 부모노드를 가리키게 되고,
        // 삭제될 노드가 부모노드의 left 인지 right 인지에 대한 정보를 가지게 된다
        while(focusNode.value != key){
            parent = focusNode; // 삭제할 노드를 찾는 과정중(while문)에서 focusNode 는 계속해서 바뀌고 parent 노드는 여기서 기억해둔다

            if(key < focusNode.value) {
                isLeftChild = true;             // 지우려는 노드가 왼쪽에 있는 노드냐 기록용
                focusNode = parent.left;
            } else {
                isLeftChild = false;            // 지우려는 노드가 오른쪽에 있는 노드냐 기록용
                focusNode = parent.right;
            }

            // 찾으려는 노드가 없는 경우
            if(focusNode == null) {
                return false;
            }
        }

        Node replacementNode; //대체노드 객체 생성

        //지우려는 focusNode의 자식이 없는 경우?
        if(focusNode.left == null && focusNode.right == null){
            if (focusNode == rootNode) //지우려는 노드의 자식이 없고, root인 경우
                rootNode = null;
            else if (isLeftChild) //왼쪽노드인경우
                parent.left = null;
            else //오른쪽노드인경우
                parent.right = null;
        }
        // 지우려는 노드의 오른쪽 자식노드가 없는 경우 (왼쪽 자식 노드만 있는 경우)
        else if(focusNode.right == null){
            replacementNode = focusNode.left;

            if (focusNode == rootNode)
                rootNode = replacementNode;
            else if (isLeftChild)
                parent.left = replacementNode;
            else
                parent.right = replacementNode;
        }
        // 지우려는 노드의 왼쪽 자식노드가 없는 경우 (오른쪽 자식 노드만 있는 경우)
        else if(focusNode.left == null){
            replacementNode = focusNode.right;

            if(focusNode == rootNode){
                rootNode = replacementNode;
            }else if(isLeftChild){
                parent.left = replacementNode;
            }else{
                parent.right =replacementNode;
            }
        }
        // 지우려는 노드의 양쪽 자식노드가 모두 있는 경우
        // 오른쪽 자식 노드의 sub tree 에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치시킨다
        else{
            // 삭제될 노드의 오른쪽 sub tree 를 저장해둔다
            Node rightSubTree = focusNode.right;

            // 삭제될 노드 자리에 오게 될 새로운 노드 (오른쪽 sub tree 에서 가장 작은 값을 가진 노드)
            // 이 노드는 왼쪽 child 가 없어야 한다 (가장 작은 값이기 때문에)
            replacementNode = getRightMinNode(focusNode.right);

            if (focusNode == rootNode)
                rootNode = replacementNode;
            else if (isLeftChild) //삭제하고자 하는 값을 찾았으니 방향이 여기 계속 있음
                parent.left = replacementNode;
            else
                parent.right = replacementNode;

            //연결시켜주기 getRightMinNode()를 통해 rightSubTree의 리턴값의 자리는 null이 됨
            replacementNode.right = rightSubTree;

            // 지우려는 노드의 오른쪽 sub tree 에 노드가 하나밖에 없는 경우
            if (replacementNode == rightSubTree)
                replacementNode.right = null;

            replacementNode.left = focusNode.left; // 지우려는 노드의 왼쪽 sub tree 를 연결시킨다

        }

        return true;
    }

    //삭제하려고 하는 노드의 오른쪽 서브트리중에서 가장 작은 값을 찾는 메소드
    private Node getRightMinNode(Node rightChildRoot) {
        Node parent = rightChildRoot;
        Node focusNode = rightChildRoot;

        while (focusNode.left != null) {
            parent = focusNode;
            focusNode = focusNode.left;
        }

        parent.left = null; //위로 올라갈 값이여서 null처리함.
        return focusNode;
    }

    // left -> root -> right
    public void inOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.left);
            System.out.print(focusNode.value + " ");
            inOrderTraverse(focusNode.right);
        }
    }

    //root -> left -> right
    public void preOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.value + " ");
            preOrderTraverse(focusNode.left);
            preOrderTraverse(focusNode.right);
        }
    }

    //left -> right -> root
    public void postOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverse(focusNode.left);
            postOrderTraverse(focusNode.right);
            System.out.print(focusNode.value + " ");
        }
    }

}


public class BSTtest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(30);
        binaryTree.insert(20);
        binaryTree.insert(40);
        binaryTree.insert(10);
        binaryTree.insert(25);
        binaryTree.insert(35);
        binaryTree.insert(45);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(23);
        binaryTree.insert(27);
        binaryTree.insert(33);
        binaryTree.insert(37);
        binaryTree.insert(42);
        binaryTree.insert(47);

        binaryTree.inOrderTraverse(binaryTree.rootNode);
        System.out.println();
        binaryTree.preOrderTraverse(binaryTree.rootNode);
        System.out.println();
        binaryTree.postOrderTraverse(binaryTree.rootNode);


    }
}
