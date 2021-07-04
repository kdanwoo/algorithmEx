package forbs.array;

import java.util.Arrays;

/**
 * 자바의 복사 방법에는 얕은 복사(Shallow copy)와 깊은 복사(Deep copy)가 있다.
 * 단순한 primitive type의 변수일 경우 얕은 복사로도 문제 없이 진행되지만,
 * reference type(객체, 배열 등)의 변수일 경우 깊은 복사를 사용해야지만 객체의 실제 데이터를 복사할 수 있다.
 *
 * 배열의 복사에 대해 정리하면,
 * 얕은 복사의 경우 원본 배열이나 복사된 배열이 변경될 때 상대 배열의 값이 같이 변경되지만
 * 깊은 복사의 경우 원본 배열이나 복사된 배열이 변경될 때 서로간의 값은 바뀌지 않는다.
 *
 * */
public class ArrayShallowCopy {
    public static void main(String[] args) {

        //얕은 복사
        int[] a = {1, 2, 3, 4};
        int[] b = a;
        System.out.println(Arrays.toString(a)); // [1, 2, 3, 4]
        System.out.println(Arrays.toString(b)); // [1, 2, 3, 4]


        // 원본 배열 값 변경
        a[1] = 10;
        System.out.println(Arrays.toString(a)); // [1, 10, 3, 4]
        System.out.println(Arrays.toString(b)); // [1, 10, 3, 4]

        // 복사한 배열 값 변경

        b[3] = 1111;
        System.out.println(Arrays.toString(a)); // [1, 10, 3, 1111]
        System.out.println(Arrays.toString(b)); // [1, 10, 3, 1111]

        /**
         * 추가적인 설명을 하면, 얕은 복사에서는 =연산자를 사용해 해당 변수에 담겨있는 값을 복사한다.
         * 배열의 경우 해당 변수에 heap의 데이터를 가리키는 참조값이 저장되어있기 때문에 참조값이 복사되어 같은 원본 배열을 가리키게 되는 것이다.
         * */


    }
}
