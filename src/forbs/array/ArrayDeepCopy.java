package forbs.array;

import java.util.Arrays;

public class ArrayDeepCopy {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = new int[a.length]; //객체를 생성했음!
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        System.out.println(Arrays.toString(a)); // [1, 2, 3, 4]
        System.out.println(Arrays.toString(b)); // [1, 2, 3, 4]


        // 원본 배열 값 변경
        a[1] = 10;
        System.out.println(Arrays.toString(a)); // [1, 10, 3, 4]
        System.out.println(Arrays.toString(b)); // [1, 2, 3, 4]


        // 복사한 배열 값 변경
        b[3] = 1111;
        System.out.println(Arrays.toString(a)); // [1, 10, 3, 4]
        System.out.println(Arrays.toString(b)); // [1, 2, 3, 1111]


    }
}
