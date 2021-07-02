package forkb.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class AutoLottoUpgrade {
    static int K;
    static int[] S;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0) {
                break;
            }
            result = new int[K];
            S = new int[K];

            for(int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }



        }



    }
}
