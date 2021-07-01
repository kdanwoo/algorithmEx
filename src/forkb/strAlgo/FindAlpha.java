package forkb.strAlgo;

import java.util.*;

/**
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 * 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를,
 * 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오. */
public class FindAlpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphaIndex = new int[26];
        String val = sc.nextLine();
        Map<Character, Integer> map = new TreeMap<>();

        for(int i =0 ; i<val.length() ; i++){
            if(!map.containsKey(val.charAt(i))){
                map.put(val.charAt(i),i);
            }
        }

        Arrays.fill(alphaIndex, -1); // 배열 채우는중!


        /**
         * 대문자 65 ~ 90
         * 소문자 97 ~ 122
         * */
        for(int i=0; i<alphaIndex.length;i++){
            char a = (char) (97 + i);
            if(map.containsKey(a)){
                alphaIndex[i] = map.get(a);
            }
        }

        for(int i=0; i< alphaIndex.length;i++){
            System.out.print(alphaIndex[i]+ " ");
        }

    }
}
