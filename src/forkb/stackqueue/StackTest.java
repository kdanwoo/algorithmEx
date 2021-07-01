package forkb.stackqueue;

import java.io.*;
import java.util.Scanner;

public class StackTest {

    public static class Stack{
        int top;
        int size;
        int stackArr[];

        public Stack(int size) {
            this.size = size;
            this.top = -1;
            this.stackArr = new int[size];
        }

        public void push(int num){
            if(!isfull()) {
                stackArr[++top] = num;
                if (top == size - 1)
                    printStack();
            }else
                System.out.println("overflow");
        }

        public boolean isfull(){
            if(top == size-1)
                return true;
            else
                return false;
        }

        public boolean isEmpty(){
            if(top==-1)
                return true;
            else
                return false;
        }

        public void pop(){
            if(top==-1)
                System.out.println("underflow");
            else
               top--;
        }

        public void printStack(){
            for(int i=0;i<stackArr.length;i++){
                System.out.print(stackArr[i]+" ");
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Stack stack = new Stack(size);
        int i=1;
        boolean status = true;

        while(i==1){
            int cmd = sc.nextInt();
            if(cmd == 0){
                int element = sc.nextInt();
                stack.push(element);
            }else if(cmd == 1){
                stack.pop();
            }else{
                break;
            }
        }

        stack.printStack();

    }
}