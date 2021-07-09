package forbs.real;

import java.util.Scanner;

public class ShortPathDFS {

    static int size,x,y,largeMin;
    static int[][] map;


    private static void dfs(int x, int y, int min) {
        // 도착 지점에 도착했을 경우.. 현재 최소값이 min보다 크면, min이 작은 것이므로 min를 최소값으로 지정
        if(x == size-1 && y==size-1) {
            if (largeMin > min)
                largeMin = min;
            return;
        }
        map[x][y] = 0; //방문체크!

        //왼쪽 이동 조건
        if(y+1 < size && map[x][y+1] == 1) {
            dfs(x, y+1, min + 1);
        }
        //오른쪽 이동 조건
        if(y-1>0 && map[x][y-1] == 1) {
            dfs(x,y-1,min+1);
        }
        //아래쪽 이동 조건
        if(x+1 < size && map[x+1][y]==1){
            dfs(x+1,y,min+1);
        }
        //위쪽 이동 조건
        if(x-1 > 0 && map[x-1][y]==1){
            dfs(x-1,y,min+1);
        }


        map[x][y] = 1; //방문체크 해제

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size =  sc.nextInt();
        x = sc.nextInt(); //시작할 좌표 입력 0 부터 시작하면됌
        y = sc.nextInt(); //시작할 좌표 입력 0 부터 시작하면됌

        map = new int[size][size];
        largeMin = size* size;


        for(int i =0 ; i<size ; i++){
            for(int j=0; j<size; j++){
                int num = sc.nextInt();
                map[i][j] = num; //열려있는 경로만 1로 체크하면 됌
            }
        }

        dfs(x,y,1);

        System.out.println(largeMin);



    }

}
