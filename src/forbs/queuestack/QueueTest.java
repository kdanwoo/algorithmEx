package forbs.queuestack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 목록을 k 요소별로 회전하는 함수를 작성한다.
 * 예를 들어, [1, 2, 3, 4, 5, 6]을 2로 회전하면 [3, 4, 5, 6, 1, 2]가 됩니다.
 * 목록의 복사본을 만들지 않고 이 문제를 해결해 보십시오. 필요한 스왑 또는 이동 작업은 몇 개입니까?
 * */
public class QueueTest {

    static void solution(int[] arrs, int rotaition){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i< arrs.length; i++){
            queue.offer(arrs[i]);
        }

        for(int j=1 ;j<=rotaition; j++){
            queue.offer(queue.poll());
        }

        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
    }


    public static void main(String[] args) {
        int[] arrs = {1, 2, 3, 4, 5, 6};
        int rotation = 3;

        solution(arrs,rotation);
    }
}
