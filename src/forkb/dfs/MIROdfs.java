package forkb.dfs;

import java.util.Scanner;

public class MIROdfs {

    static int SIZE;
    static int[][] map;
    static int x,y;
    static int maxMin;

    private static void dfs(int x, int y, int min) {
        // 도착 지점에 도착했을 경우.. 현재 최소값이 l보다 크면, l이 작은 것이므로 l를 최소값으로 지정
        if(x == SIZE-1 && y==SIZE-1) {
            if (maxMin > min)
                maxMin = min;
            return;
        }
        map[x][y] = 0; //방문체크!

        // 오른쪽 이동 조건
        if(y+1 < SIZE && map[x][y+1] == 1) {
            dfs(x, y+1, min + 1);
        }
        // 왼쪽 이동 조건
        if(y-1 >= 0 && map[x][y-1] == 1) {
            dfs(x, y-1, min+1);
        }
        // 위로 이동 조건
        if(x-1 >= 0 && map[x-1][y] == 1) {
            dfs(x-1, y, min+1);
        }
        // 아래로 이동 조건
        if(x+1 < SIZE && map[x+1][y]==1){
            dfs(x+1, y, min+1);
        }

        map[x][y] = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SIZE = sc.nextInt(); //정사각형일 경우
        x = sc.nextInt(); //시작할 좌표 입력 0 부터 시작하면됌
        y = sc.nextInt(); //시작할 좌표 입력 0 부터 시작하면됌
        map = new int[SIZE][SIZE];
        maxMin = SIZE * SIZE;


        for(int i =0 ; i<SIZE ; i++){
            for(int j=0; j<SIZE; j++){
                int num = sc.nextInt();
                map[i][j] = num; //열려있는 경로만 1로 체크하면 됌
            }
        }

        dfs(x,y,1);

        System.out.println(maxMin);

    }


}
