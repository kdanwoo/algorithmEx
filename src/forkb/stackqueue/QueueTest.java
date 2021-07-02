package forkb.stackqueue;
import java.util.*;

/**
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
 * 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 * progresses	speeds	return
 * [93, 30, 55]	[1, 30, 5]	[2, 1]
 * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 *
 * 제한 사항
 * */
public class QueueTest {
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> task = new LinkedList<>();
            ArrayList<Integer> res = new ArrayList<>();
            int total =0;

            //배열을 담음 큐에 담는다. 순차적으로.
            for(int i=0; i<progresses.length; i++){
                task.add((int) Math.ceil((100 - progresses[i]) / (double)speeds[i]));
            }
            int prevTask = task.poll();
            int releaseCnt = 1;

            while(!task.isEmpty()){
                int currentTask = task.poll();
                if(prevTask >= currentTask){
                    releaseCnt++;
                }else{
                    res.add(releaseCnt);
                    releaseCnt = 1;
                    prevTask = currentTask;
                }
            }

            res.add(releaseCnt);

            int[] ret = new int[res.size()];
            Iterator<Integer> iterator = res.iterator();
            for (int i = 0; i < ret.length; i++)
            {
                ret[i] = iterator.next().intValue();
            }
            return ret;
        }
    }
    public static void main(String[] args) {
        int[] progresses = {93,35,55};
        int[] speeds = {1,30,5};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(progresses, speeds)));


    }
}
