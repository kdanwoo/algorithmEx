package forbs.queue;

import javax.print.attribute.standard.QueuedJobCount;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockQueue {

    static class Solution {

        Queue<Integer> stockQueue;
        int min;

        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            stockQueue = new LinkedList<>();
            min = prices[0];

            for(int i=0; i<prices.length; i++){
                if(min> prices[i]){
                    min = prices[i];
                }
                stockQueue.offer(prices[i]);
            }

            while(!stockQueue.isEmpty()){
                int i = 0;
                //answer[i] = stockAnalysis(stockQueue.poll());
                i++;
            }


            return answer;
        }
//
//        private int stockAnalysis(Queue<Integer> queue){
//            Queue<Integer> temp = queue;
//
//            int tempval = temp.poll();
//            return null;
//        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution.solution(arr)));
    }
}
