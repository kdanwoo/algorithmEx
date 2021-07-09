package forbs.queue;

import javax.sound.sampled.SourceDataLine;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bridge가 비어 있으면 현재 truck을 추가하고 다음 트럭으로 넘어간다.
 * bridge가 bridge_length만큼 꽉 차있으면 마지막 트럭을 bridge에서 제거한다.
 * bridge의 weightSum을 고려하여
 * truck을 추가할 수 있으면 추가하고 다음 트럭으로 넘어간다.
 * truck을 추가할 수 없으면 무게 0의 EMPTY를 추가한다.
 * */
public class QueueTest {

    static class Solution {
        private static final int EMPTY = 0;

        private int weightSum;
        private Queue<Integer> bridge;
        private int answer;

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            answer = 0;
            weightSum = 0;
            bridge = new LinkedList<>();

            for (int truck : truck_weights) {
                while (true) {
                    if (bridge.isEmpty()) {
                        addTruckOnBridge(truck);
                        break;
                    }

                    if (bridge.size() == bridge_length) {
                        weightSum -= bridge.poll();
                    } else if (weightSum + truck <= weight) {
                        addTruckOnBridge(truck);
                        break;
                    } else {
                        addTruckOnBridge(EMPTY);
                    }
                }
            }

            return answer + bridge_length;
        }

        private void addTruckOnBridge(int truck) {
            bridge.offer(truck);
            weightSum += truck;
            answer++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int length = 2;
        int weight = 10;
        int[] truckWeight = {7,4,5,6};

        System.out.println(solution.solution(2,10,truckWeight));
    }
}
