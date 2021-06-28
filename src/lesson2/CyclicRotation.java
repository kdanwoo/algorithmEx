package lesson2;

import java.util.Arrays;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if( K % A.length == 0 )
            return A;
        else{
            int val = K % A.length; //나머지 저장
            int[] temp1 = Arrays.copyOfRange(A,0, A.length-val );
            int[] temp2 = Arrays.copyOfRange(A,A.length-val,A.length);

            int[] dest = new int[temp1.length+temp2.length];


            //arr1을 dest로 복사 (index 0 ~ index 2)
            System.arraycopy(temp2, 0, dest, 0, temp2.length);

            //arr2를 dest로 복사 (index 3 ~ index 5)
            System.arraycopy(temp1, 0, dest, temp2.length, temp1.length);
            return dest;
         }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 4;
        CyclicRotation cyclicRotation = new CyclicRotation();
        cyclicRotation.solution(arr,k);
    }
}
