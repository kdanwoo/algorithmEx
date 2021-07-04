package forbs.array;

import java.util.Arrays;

public class ArrayDeepCopy3 {
    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5, 6, 7 };

        // a 배열 전체 복사
        int[] b1 = Arrays.copyOf(a, a.length);
        int[] b2 = Arrays.copyOfRange(a, 0, a.length);

        System.out.println(Arrays.toString(b1));
        b2[0] = 100;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b2));


        // a 배열 3개 요소값 복사 (첫 번째 요소부터 시작해서 3개 가져옴)
        int[] b11 = Arrays.copyOf(a, 3);
        System.out.println(Arrays.toString(b11));

        // a 배열 3개 요소값 복사 (4번째 요소부터 시작해서 3개 가져옴) 4,5,6
        int[] b22 = Arrays.copyOfRange(a, 3, 6);
        System.out.println(Arrays.toString(b22));

    }
}
