package forkb.dfs;

import java.util.Scanner;

public class DFSTest {

    static int vertexCnt;
    static int startVertex;
    static int[] visited;
    static int[][] adjArr;
    static int vt1, vt2;

    private static void dfs(int startVertex) {

        //제일중요해! dfs함수가 호출되지마자 visited에 체크를 해줘야해!
        visited[startVertex] = 1;

        for(int i=1; i<=vertexCnt ; i++){
            if(adjArr[startVertex][i]==1 && visited[i]==0){
                //인접행렬에서 간선이 연결되어 있는 지 && 방문하지 않았는지!
                System.out.println(startVertex + "->" + i + "로 이동합니다");
                dfs(i); //백트레킹이 일어나는 상황을 잘 알아야해!
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        vertexCnt = sc.nextInt();
        startVertex = sc.nextInt();
        visited = new int[vertexCnt+1]; //정점의 개수만큼 방문한것을 체크하기 위해 담아둠. 정점이 1로시작하니까!
        adjArr = new int[vertexCnt+1][vertexCnt+1]; //점을 1로 해둠 계산하기 쉽게

        while(true){
            vt1 = sc.nextInt();
            vt2 = sc.nextInt();

            if(vt1 < 0 && vt2 < 0) //두 개의 점이 0보다 작을 경우 break;
                break;
            //정점 vt1과 vt2가 연결되었음을 표기
            //인접행렬의 내용을 이해하면 위에 코드를 이해할 수 있습니다.

            //예를 들어 1정점 2정점이 연결되었으면 [1][2] 와 [2][1] 배열의 자리가 1이된다.
            //입력값의 맨 마지막에 -1-1 넣어서 break 걸리게할거임!
            adjArr[vt1][vt2] = adjArr[vt2][vt1] = 1;
        }

        dfs(startVertex);



    }


}
