package forkb.strAlgo;


import java.util.Scanner;

/**
 * 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
 * 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
 * */
public class RepeativeStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] repeat = new int[total];
        String[] str = new String[total];

        for(int i=0;i<total;i++){
            repeat[i] = sc.nextInt();
            str[i] = sc.next();
        }
        for (int i=0;i<total;i++) {
            for (int j=0;j<str[i].length();j++) {
                char c=str[i].charAt(j);
                for (int k=0;k<repeat[i];k++)
                    System.out.print(c);
            }
            System.out.println();
        }


    }
}
