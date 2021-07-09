package forbs.real;

import java.util.Scanner;

public class DFSex {

    static int vertexCnt;
    static int startVertex;
    static int[][] adjVertexMap;
    static int[] visited;

    private static void startDFS(int startVertex) {

        visited[startVertex] = 1; //방문한 기록을 남김

        for(int i=1; i<=vertexCnt; i++) {
            if(adjVertexMap[startVertex][i] ==1 && visited[i]==0){
                //인접행렬에서 정점이 연결되어 있고, 해당 정점을 방문한적이 없을때
                System.out.println(startVertex + "->" + i + "로 이동합니다");
                startDFS(i);
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        vertexCnt = sc.nextInt();
        startVertex = sc.nextInt();
        adjVertexMap = new int[vertexCnt+1][vertexCnt+1];
        visited = new int[vertexCnt+1];
        int x,y;

        while (true){
            x = sc.nextInt();
            y = sc.nextInt();

            if(x<0 && y<0){
                break;
            }

            //정점들을 연결 정보를 만들어준다. 인접행렬
            adjVertexMap[x][y] = adjVertexMap[y][x] = 1;


        }

        startDFS(startVertex);

    }


}
