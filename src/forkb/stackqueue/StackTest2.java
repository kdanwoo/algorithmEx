package forkb.stackqueue;

import java.util.Scanner;

/**
 * N x N개의 수가 주어지고, 겹치지 않는 각 행과 열에서 수를 하나씩 뽑고
 * 이 N개의 수의 합을구할때 최소값을 구하는 프로그램을 구하시오
 * */
public class StackTest2 {
    public static void main(String[] args) {
        //Stack을 활용한 ? 재귀?
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[][] numArr = new int[num][num];
        int[] visited = new int[num];
        int result = 0; //너의 역할?

        //2차원 정수 초기화
        for(int i =0;i<num;i++){
            for(int j=0; j<num; j++){
                numArr[i][j] = sc.nextInt();
            }
        }


    }
}
