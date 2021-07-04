package forbs.array;

import java.util.Arrays;

public class ArrayDeepCopy2 {
    public static void main(String[] args) {

        /**
         * 자바에서 모든 클래스의 부모 클래스는 Object 클래스이고 Object 클래스에는 clone() 메서드가 있다.
         * 객체 생성 후, 복제를 할 때 사용된다. clone() 메소드를 이용해 새로운 배열을 생성하고 b변수에는 a변수와는 다른 참조값을 가지게된다.
         * */
        int[] a = {1, 2, 3, 4};
        int[] b = a.clone();

        /**
         * getter를 통해 배열을 가져와서 그 배열을 변경해버리면 원본 배열까지 변경되는 문제가 있다.
         * 이러한 문제를 해결하기 위해 배열에 대한 getter 함수에서는 clone() 메서드를 사용한다.
         * */



    }
}
