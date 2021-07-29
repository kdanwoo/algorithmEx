package fibonacci;

import java.util.Scanner;

//피보나치 수열을 재귀, 동적, 반복으로 모두 구하시오.
public class Fibonacci {

    public static int[] fiboDpArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }

    private static int fibo_loop(int n) {
        if(n <= 1){
            return 1;
        }else{
            int a = 0;
            int b = 1;
            int sum = 0;

            for(int i=2; i<= n ; i++){
                sum = a+b;
                a = b;
                b = sum;
            }
            return sum;
        }
    }

    private static int fibo_dinamic(int n) {
        //memorization 기법 사용
        fiboDpArray = new int[n + 1];
        fiboDpArray[0] = 0;
        fiboDpArray[1] = 1;

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                fiboDpArray[i] = fiboDpArray[i - 2] + fiboDpArray[i - 1];
            }
        }
        return fiboDpArray[n];
    }

    private static int fibo_resursion(int n) {
        if(n == 0){
            return 0;
        }else if(n==1){
            return 1;
        }
        return fibo_resursion(n-1) + fibo_resursion(n-2);
    }
}
