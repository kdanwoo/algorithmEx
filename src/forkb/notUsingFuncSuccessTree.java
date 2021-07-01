package forkb;

public class notUsingFuncSuccessTree {
    private static class Node {
        private int data;
        private Node left, right;

        public Node(int input) {
            this.data = input;
            this.left = null;
            this.right = null;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }


    private Node root;
    private int count = 0;

    public Node getRoot() {
        return this.root;
    }

    public Node searchingNode(int input) { // 노드 검색
        if (root == null) {
            return null;
        }
        Node moveNode = root;
        while (moveNode.data != input) {
            if (input < moveNode.data) {
                moveNode = moveNode.left;
            } else {
                moveNode = moveNode.right;
            }
            if (moveNode == null) {
                return null;
            }
        }
        return moveNode;
    }


    public void addChild(int input) { // 노드 삽입
        if (searchingNode(input) != null) { // 노드 값이 중복되면 삽입없이 종료
            System.out.println("already exist in tree " + input);
            return;
        }

        Node newNode = new Node(input);

        if (root == null) { // 트리가 없다면 root 생성
            root = newNode;
        } else {
            Node moveNode = root; // 움직일 노드
            Node pointer;

            while (true) {
                pointer = moveNode;

                if (input < pointer.data) {
                    moveNode = pointer.left;

                    if (moveNode == null) {
                        pointer.left = newNode;
                        return;
                    }
                } else {
                    moveNode = pointer.right;

                    if (moveNode == null) {
                        pointer.right = newNode;
                        return;
                    }
                }
            }
        }

    }

    public void deleteNode(int input) {
        Node moveNode = root;
        Node pointer = root;

        boolean leftflag = true;

        // 삭제 될 노드로 이동
        while (moveNode.data != input) {
            pointer = moveNode;

            if (input < moveNode.data) {
                leftflag = true;
                moveNode = pointer.left;
            } else {
                leftflag = false;
                moveNode = pointer.right;
            }
        }

        Node replacementNode; // 변경될 노드

        // 자식 노드가 없는 노드 삭제
        if (moveNode.left == null && moveNode.right == null) {
            if (moveNode == root) {
                root = null;
            }
            if (leftflag) {
                pointer.left = null;
            } else {
                pointer.right = null;
            }
        }

        // 자식 노드가 한개 있는 노드 삭제
        // 어차피 왼쪽만 있은 왼쪽만 지우면 끝
        else if (moveNode.right == null) {
            if (moveNode == root) {
                root = null;
            }
            pointer.left = null;
        }
        // 오른쪽만 있다면 오른쪽만 삭제
        else if (moveNode.left == null) {
            if (moveNode == root) {
                root = null;
            }
            pointer.right = null;
        }

        // 자식 노드가 두개일 때
        else {
            // 삭제될 노드의 오른쪽 트리 저장
            Node subTree = moveNode.right;
            // 삭제될 노드의 서브트리에서 가장 작은 노드 확인
            replacementNode = subTree.left;
            subTree.left = null;
            // root 라면 그냥 바꿔줌
            if (moveNode == root) {
                root = replacementNode;
            }

            // flag 통해서 root 좌우측 판단
            if (leftflag) {
                pointer.left = replacementNode;
            } else {
                pointer.right = replacementNode;
            }

            // 바꿀 노드가 null이 아니라면
            // 바꿀 노드의 오른쪽에 서브트리 결합
            // 바꿀 노드가 서브트리면 null
            // 바꿀 노드의 왼쪽에 기존 노드의 좌측 노드 결합
            if (replacementNode != null) {
                replacementNode.right = subTree;
                if (replacementNode == subTree) {
                    replacementNode.right = null;
                }
                replacementNode.left = moveNode.left;
            }
        }
    }

    public void inOrder(Node node) { // left - root - right
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.data);
            inOrder(node.getRight());
        }
    }

    public void preOrder(Node node) { // root - left - right
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void postOrder(Node node) { // left - right - root
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.data);
        }
    }


    public static void main(String[] args) {
        notUsingFuncSuccessTree tree = new notUsingFuncSuccessTree();
        tree.addChild(6);
        tree.addChild(4);
        tree.addChild(2);
        tree.addChild(5);
        tree.addChild(5);
        tree.addChild(9);
        tree.addChild(8);
        tree.addChild(11);
        tree.addChild(10);
        tree.addChild(13);
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.postOrder(tree.getRoot());
        System.out.println();
        tree.deleteNode(2);
        tree.deleteNode(9);
        System.out.println();
        tree.preOrder(tree.getRoot());
    }
}