package lesson2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> integerMap = new HashMap<>();

        for(int i=0 ; i < A.length; i++){
            if(integerMap.containsKey(A[i])){
                //key가 있다면
                int val = integerMap.get(A[i]);
                integerMap.put(A[i],val+1);
            }else{
                integerMap.put(A[i],1);
            }
        }

        // 홀수 값 추출
        for( int key : integerMap.keySet() ){
            if(integerMap.get(key)% 2 ==1)
                return key;
        }

        return 0;
    }

    public static void main(String[] args) {
        //중복을 제거하라는 말? 중복 Set?
        int[] a = {9,3,9,3,3,3,7};
        OddOccurrencesInArray occurrences = new OddOccurrencesInArray();
        System.out.println(occurrences.solution(a));
    }
}
