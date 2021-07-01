package lesson3;

import java.text.BreakIterator;

public class FrogJmp {

    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int gap = Y - X;
        if(Y==X)
            return 0;
        else if(gap<D) //차이가 작을 경우 뛰는 거리보다!
            return 1;
        else{
            if(gap%D > 0){
                int val = gap/D;
                return val+1;
            }else if(gap%D ==0){
                int val = gap/D;
                return val;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();
        System.out.println(frogJmp.solution(1,1,3));
    }
}
