package forbs.bst;

/**
 * 이제 이진 탐색 트리를 구현해보자. 기본적으로 삽입과 삭제 연산을 가지고 있고
 * 트리의 탐색은 전위(pre-order), 후위(post-order) 그리고 중위(in-order) 순회가 있다.
 * */
public class BinaryTree {

    //root노드를 null로 초기화 시킨다
    Node rootNode = null;

    //노드 검색
    public Node findNode(int key) {
        // 트리가 비었을 때
        if (rootNode == null) return null;

        Node focusNode = rootNode; //탐색용 노드

        while (focusNode.value != key) {
            if (key < focusNode.value) {              // 현재노드보다 작으면
                focusNode = focusNode.leftChild;    // 왼쪽으로
            } else {                                // 크면
                focusNode = focusNode.rightChild;   // 오른쪽으로
            }

            // 찾으려는 노드가 없을 때 -> 단말노드까지 내려온 경우
            if (focusNode == null)
                return null;
        }

        return focusNode;
    }

    /**
     * 특정 노드 입력
     * 해당 값을 가진 노드 찾고, 루트가 null이 아닌지, 루트보다 큰 값인지 아닌지
     */
    public void insertNode(int key){
        if (findNode(key) != null) return;  // 이미 존재하면 그냥 리턴

        Node newNode = new Node(key); //존재하지 않으니까 새로운 노드를 생성해줌!

        if(rootNode == null){
            rootNode = newNode; //트리가 비었다면, root에 넣어준다
        }else{
            Node focusNode = rootNode;  //  탐색용 노드
            Node parent;            //  탐색용 노드의 부모 노드

            while(true) {
                parent = focusNode; //  이동

                if (key < parent.value) {             //  삽입하려는 키가 현재 노드보다 작으면
                    focusNode = parent.leftChild;   //  왼쪽으로 이동

                    if (focusNode == null) {        //  왼쪽 노드가 비어있으면
                        parent.leftChild = newNode; //  왼쪽 노드에 삽입
                        return;
                    }
                } else {                            //  삽입하려는 키가 현재 노드와 같거나 크다면
                    focusNode = parent.rightChild;  //  오른쪽으로 이동

                    if (focusNode == null) {        //  오른쪽 노드가 비어있으면
                        parent.rightChild = newNode;//  오른쪽 노드에 삽입
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
    public boolean deleteNode(int key){
        // focusNode 와 parent 가 같을 수 있는 경우는 찾으려는 key 가 root 인 경우
        Node focusNode = rootNode;
        Node parent = rootNode;

        boolean isLeftChild = true;

        // while 문이 끝나고 나면 focusNode 는 삭제될 노드를 가리키고,
        // parent 는 삭제될 노드의 부모노드를 가리키게 되고,
        // 삭제될 노드가 부모노드의 left 인지 right 인지에 대한 정보를 가지게 된다
        while(focusNode.value != key) {
            parent = focusNode; // 삭제할 노드를 찾는 과정중(while문)에서 focusNode 는 계속해서 바뀌고 parent 노드는 여기서 기억해둔다

            if(key < focusNode.value) {
                isLeftChild = true;             // 지우려는 노드가 왼쪽에 있는 노드냐 기록용
                focusNode = parent.leftChild;
            } else {
                isLeftChild = false;            // 지우려는 노드가 오른쪽에 있는 노드냐 기록용
                focusNode = parent.rightChild;
            }

            // 찾으려는 노드가 없는 경우
            if(focusNode == null) {
                return false;
            }
        }

        Node replacementNode; //대체노드 객체 생성

        // 지우려는 노드의 자식 노드가 없는 경우
        if(focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == rootNode)
                rootNode = null;
            else if (isLeftChild) //왼쪽노드인경우
                parent.leftChild = null;
            else //오른쪽노드인경우
                parent.rightChild = null;
        }
        // 지우려는 노드의 오른쪽 자식노드가 없는 경우 (왼쪽 자식 노드만 있는 경우)
        else if(focusNode.rightChild == null) {
            replacementNode = focusNode.leftChild;

            if (focusNode == rootNode)
                rootNode = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;
        }

        // 지우려는 노드의 왼쪽 자식노드가 없는 경우 (오른쪽 자식 노드만 있는 경우)
        else if (focusNode.leftChild == null) {
            replacementNode = focusNode.rightChild;
            if (focusNode == rootNode)
                rootNode = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;
        }
        // 지우려는 노드의 양쪽 자식노드가 모두 있는 경우
        // 오른쪽 자식 노드의 sub tree 에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치시킨다
        else {
            // 삭제될 노드의 오른쪽 sub tree 를 저장해둔다
            Node rightSubTree = focusNode.rightChild;

            // 삭제될 노드 자리에 오게 될 새로운 노드 (오른쪽 sub tree 에서 가장 작은 값을 가진 노드)
            // 이 노드는 왼쪽 child 가 없어야 한다 (가장 작은 값이기 때문에)
            replacementNode = getRightMinNode(focusNode.rightChild);

            if (focusNode == rootNode)
                rootNode = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;

            //연결시켜주기 getRightMinNode()를 통해 rightSubTree의 리턴값의 자리는 null이 됨
            replacementNode.rightChild = rightSubTree;

            // 지우려는 노드의 오른쪽 sub tree 에 노드가 하나밖에 없는 경우
            if (replacementNode == rightSubTree)
                replacementNode.rightChild = null;

            replacementNode.leftChild = focusNode.leftChild; // 지우려는 노드의 왼쪽 sub tree 를 연결시킨다
        }

        return true;
    }

    //삭제하려고 하는 노드의 오른쪽 서브트리중에서 가장 작은 값을 찾는 메소드
    private Node getRightMinNode(Node rightChildRoot) {
        Node parent = rightChildRoot;
        Node focusNode = rightChildRoot;

        while (focusNode.leftChild != null) {
            parent = focusNode;
            focusNode = focusNode.leftChild;
        }

        parent.leftChild = null; //위로 올라갈 값이여서 null처리함.
        return focusNode;
    }

    public void inOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.leftChild);
            System.out.print(focusNode.value + " ");
            inOrderTraverse(focusNode.rightChild);
        }
    }

    public void preOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.value + " ");
            preOrderTraverse(focusNode.leftChild);
            preOrderTraverse(focusNode.rightChild);
        }
    }

    public void postOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverse(focusNode.leftChild);
            postOrderTraverse(focusNode.rightChild);
            System.out.print(focusNode.value + " ");
        }
    }



}
