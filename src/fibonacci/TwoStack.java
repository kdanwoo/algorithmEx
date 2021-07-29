package fibonacci;

import java.util.Stack;

//스택2개로 큐만들기
public class TwoStack {

    static class StackQueueTest{
        Stack<Integer> inqueue;
        Stack<Integer> outqueue;

        public StackQueueTest() {
            this.inqueue = new Stack<>();
            this.outqueue = new Stack<>();
        }

        void inQueue(int a){
            inqueue.push(a); //입력용스택에 다넣어줌
        }

        int deQueue(){
            //선입선출이 되기 위해서 출력용스택에 우선 다 옮겨줘야함
            if(outqueue.isEmpty()){
                while (!inqueue.isEmpty()){
                    outqueue.push(inqueue.pop());
                }
            }
            return outqueue.pop();
        }
    }
    public static void main(String[] args) {
        StackQueueTest stackQueue = new StackQueueTest();

        stackQueue.inQueue(1);
        stackQueue.inQueue(2);
        System.out.println(stackQueue.deQueue());
        stackQueue.inQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }
}
