package forkb.strAlgo;

import java.util.Scanner;

public class TotalSumMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());	// nextInt() → 개행문자 無
        String str = sc.nextLine();
        String[] strings = str.split("");

        sc.close();

        long sum = 0;	// 크기가 큰 숫자를 저장하기 위함

        for(int i=0 ; i<n ; i++){
            sum = sum + Integer.parseInt(strings[i]);
        }

        System.out.println(sum);

    }
}
