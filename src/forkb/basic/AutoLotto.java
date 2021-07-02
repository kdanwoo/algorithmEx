package forkb.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 로또번호를 자동으로 뽑아주는 알고리즘을 구현하고자 합니다.
 * 조건은 아래와 같습니다.
 * 1. 1~45까지의 숫자 중 1개의 숫자를 임의로 뽑는다
 * 2. 특정 자료구조에 저장한다. 이미 뽑은 숫자와 중복일 경우 새로 뽑는다. 3. 자료구조의 크기가 6이 될 때까지 반복한다.
 * 위의 연산을 반복하여 총 5개의 로또 번호를 자동으로 생성해 보겠습니다.
 * */
public class AutoLotto {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0 ; i<6 ;i++){
            int rand = (int) ((Math.random() * 45)+1);
            if(map.containsKey(rand)){
                map.put(rand, map.get(rand)+1);
            }else{
                map.put(rand,1);
            }
        }
        for(int k : map.keySet()){
            System.out.println(k);
        }
    }
}
