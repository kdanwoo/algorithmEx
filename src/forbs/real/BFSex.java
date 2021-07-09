package forbs.real;

import java.util.*;

public class            BFSex {

    static int vertexCnt;
    static int edgeCnt;
    static int startVertex;
    static ArrayList<LinkedList<Integer>> adjListArr;
    static boolean[] visited;

    private static void BFSstart(LinkedList<Integer>[] adjList, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true; //방문체크

        queue.add(startVertex); //큐에 삽입

        while(queue.size() != 0) {
            startVertex = queue.poll();
            System.out.print(startVertex + " ");

            Iterator<Integer> iter = adjList[startVertex].listIterator();
            while(iter.hasNext()) {
                int w = iter.next(); //정점하고 연결되어 있는 값임. 정렬했기때문에 작은값부터 봄
                if(!visited[w]) { //방문한적이 없다면
                    visited[w] = true; //방문체크를 하고
                    queue.add(w); // 큐에 넣어준다
                }
            }
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        vertexCnt = sc.nextInt(); // 정점의 총 개수
        edgeCnt = sc.nextInt(); // 간선의 총 개수
        startVertex = sc.nextInt(); // 탐색을 시작할 정점의 번호
        visited=  new boolean[vertexCnt+ 1]; // 방문 여부를 검사할 배열, 정점이 1부터 시작하니까
        int x, y;

        // 1~N까지 각각의 인접(연결 정보)를 가진 리스트들을 만들어 연결리스트의 배열로서 관리
        LinkedList<Integer>[] adjList = new LinkedList[vertexCnt + 1]; //정점이 1부터 시작해서

        //각 정점에 해당하는 리스트들을 초기화하는 작업
        for (int i = 0; i <= vertexCnt; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        //간선의 개수를 입력받았으니, 연결리스트에 저장해줘야함
        for(int i =1 ; i<= edgeCnt ; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            /**
             * 인접행렬 같은 경우는
             * adjArr[v1][v2] = adjAdr[v2][v1] = 1 이런식으로 만들어줬음
             * */
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        //중요해 ~ 정렬해줘야해
        for (int i = 1; i <= vertexCnt; i++) { //각각 정점이 갖고있는 연결리스트들을 순회
            Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬
        }

        System.out.println("BFS START");
        BFSstart(adjList,startVertex);


    }


}
