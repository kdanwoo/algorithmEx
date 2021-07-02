package forkb.backtracking;

import java.util.Scanner;

/**
 * 주사위를 N개 던져서 나올 수 있는 경우의 수를 모두 출력하는 코드를 작성한다고 가정해 봅시다.
 * */
public class DiceBackTrack {

    static int num;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();
        result = new int[num];
        int diceNum=0;      //0~(N-1)번 주사위를 의미

        //2. 재귀함수 호출
        roll(diceNum);

    }

    private static void roll(int diceNum) {
    }
}
