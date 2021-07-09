package forbs.real;

import java.util.Stack;

public class TwoStackQueue {

    static class StackQueue{
        Stack inqueue;
        Stack outqueue;

        StackQueue(){
            this.inqueue = new Stack<>();
            this.outqueue = new Stack<>();
        }

        void inQueue(int v){
            inqueue.add(v); //입력용 스택에 넣어둠
        }

        int outQueue(){ //선입선출이 되기위해서 ->입력용스택을 출력용 스택에 다 넣어줘야함
            if(outqueue.isEmpty())//** point **
                while(!inqueue.isEmpty()){
                    outqueue.add(inqueue.pop());
                }
            return (int) outqueue.pop();
        }
    }


    public static void main(String[] args) {

        StackQueue q = new StackQueue();

        q.inQueue(1);
        q.inQueue(2);

        System.out.println(q.outQueue());

        q.inQueue(3);

        System.out.println(q.outQueue());
        System.out.println(q.outQueue());
    }
}
