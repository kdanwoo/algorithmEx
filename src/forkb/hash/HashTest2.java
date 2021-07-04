package forkb.hash;

import java.util.HashMap;

/**
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * */
public class HashTest2 {
    static class Solution {
        public boolean solution(String[] phoneBook) {
            boolean answer = true;


            // 1. HashMap 만들기
            HashMap<String, Integer> map = new HashMap<>();

            // 2. 모든 전화번호 Hashing 하기 (Hash Map에 추가하기)

            for(int i = 0; i < phoneBook.length; i++)
                map.put(phoneBook[i], i);


            for(int i = 0; i < phoneBook.length; i++) {
                for(int j = 1; j < phoneBook[i].length(); j++) {
                    if(map.containsKey(phoneBook[i].substring(0,j))) {
                        answer = false;
                        return answer;
                    }
                }
            }



            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] book = {"119", "97674223", "1195524421"};
        System.out.println(sol.solution(book));
    }
}
