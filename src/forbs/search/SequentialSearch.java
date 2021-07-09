package forbs.search;

import java.util.Scanner;

public class SequentialSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int n, flag = 0;
        System.out.print("찾으시려는 숫자를 입력하시오 : ");

        n = sc.nextInt();

        for(int i=0; i<arr.length; i++){
            if(arr[i] == n){
                flag = 1;
                System.out.printf("찾았습니다. 찾으시는 문자는 %d 에 잇습니다.", i);
            }
        }

        if(flag==0){
            System.out.println("찾을수 없음");
        }

    }
}
