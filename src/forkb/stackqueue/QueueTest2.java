package forkb.stackqueue;

import java.util.*;

/**
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 * 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
 * */
public class QueueTest2 {

    static class Solution {
        public int solution(int[] priorities, int location) {
            Queue<Printer> queue = new LinkedList<>();
            int answer = 0;

            for (int i = 0; i < priorities.length; i++) { // print큐에 인덱스번호, 우선순위 삽입
                queue.offer(new Printer(i, priorities[i]));
            }

            while (!queue.isEmpty()) {

                boolean flag = false;
                int com = queue.peek().prior; //자체 우선 순위 값
                for (Printer p : queue) {
                    if (com < p.prior) { // 맨앞의 수보다 큰 숫자가 존재하면
                        flag = true;
                    }
                }

                if (flag) {
                    queue.offer(queue.poll());
                } else {// 현재 맨앞의 숫자가 가장 클 때
                    if (queue.poll().location == location) {
                        answer = priorities.length - queue.size();
                    }
                }
            }

            return answer;
    }

    class Printer {
            int location; //index
            int prior; //우선순위

            Printer(int location, int prior) { //생성자
                this.location = location;
                this.prior = prior;
            }
        }
    }

    public static void main(String[] args) {
        int[] priorities = {1,3,2,5,4};
        int location = 3;

        Solution sol = new Solution();
        System.out.println(sol.solution(priorities, location));
    }
}
