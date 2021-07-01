package forkb.strAlgo;

import java.util.*;

/**
 *
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
 * 단, 대문자와 소문자를 구분하지 않는다.
 * */
public class MostAlphaCnt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MostAlphaCnt mostAlphaCnt = new MostAlphaCnt();

        String str = sc.nextLine();
        str = str.toLowerCase(Locale.ROOT);

        String[] strings = str.split("");
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<strings.length; i++){
            if(map.containsKey(strings[i])){
                int val = map.get(strings[i]) + 1;
                map.put(strings[i],val);
            }else
                map.put(strings[i],1);
        }

        int cnt = 0;
        String res = null;

        for(Map.Entry<String, Integer> m : map.entrySet()) {
            if(m.getValue()==Collections.max(map.values())) {
                cnt = cnt + 1;
                res = m.getKey();
            }
        }

        if(cnt > 1)
            System.out.println("?");
        else
            System.out.println(res);


    }

}
