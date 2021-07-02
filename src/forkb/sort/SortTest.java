package forkb.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * */
public class SortTest {

    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            String[] stringArr = new String[numbers.length];

            for(int i=0; i<numbers.length; i++){
                stringArr[i] = String.valueOf(numbers[i]);
            }

            /**
             * String 배열을 내림차순으로 정렬한다.
             * 인터페이스 Comparator 를 사용하기 위해 메소드 재정의를 한다.
             * 재정의 과정에서 내림차순으로 수정한다.
             * 내림차순 : return (o2+o1).compareTo(o1+o2);
             * 오름차순 : return (o1+o2).compareTo(o1+o2);
             */
            Arrays.sort(stringArr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2+o1).compareTo(o1+o2);
                }
            });

            /** 4 **/
            if(stringArr[0].startsWith("0")) {
                answer += "0";
            } else {
                for(int j=0; j<stringArr.length; j++) {
                    answer += stringArr[j];
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {6, 10, 2};
        System.out.println(solution.solution(numbers));
    }
}
