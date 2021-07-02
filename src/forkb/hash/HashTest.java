package forkb.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가
 * 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 *
 * */
public class HashTest {
    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String, Integer> map = new HashMap<>();


            for (int i = 0; i < clothes.length; i++) {
                // 종류 여부 판단. 같은 종류 일 경우 Value + 1
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
            }

            // 경우의 수 체크 answer *= (옷 가지수 + 안 입을 경우)
            for (int val : map.values()){
                answer *= (val+1);
            }

            // 모두 다 안입는 경우는 존재하지 않으므로 -1
            return answer-1;

        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(sol.solution(clothes));
    }
}
