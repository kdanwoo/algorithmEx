package forkb.basic;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 표준입력(Scanner)를 통해 "N"을 입력 받습니다.
 * 입력 받은 값을 이용해 N*N 크기의 이중배열을 생성합니다. 짝수행의 경우 왼쪽에서 오른쪽, 홀수행의 경우 반대로 수를 채워 넣습니다.
 * */
public class FillArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] numArr = new int[num][num];

        for(int i=0;i<num;i++){
            if(i%2==1){
                //홀수
                for(int j=num-1; j>=0; j--){
                    numArr[i][j] = sc.nextInt();
                }
            }else{
                for(int j=0; j<num; j++){
                    numArr[i][j] = sc.nextInt();
                }
            }
        }

        System.out.println(Arrays.deepToString(numArr));
;    }
}
