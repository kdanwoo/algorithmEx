package lesson1;

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String a = Integer.toBinaryString(N);
        String[] arr = a.split("");

        int max =0;
        int corrent = 0;

        for(int i=0;i<arr.length;i++){
           if(arr[i].equals("0")){
                corrent++;
            }else{
                max = (max>corrent) ? max : corrent;
                corrent = 0;
            }
        }

        return max;
    }
}
public class lesson1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1041));
    }
}
