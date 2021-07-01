package forkb.strAlgo;

import java.util.Scanner;

class Asci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력값, String 저장
        String ascii = sc.next();
        System.out.println((int)ascii.charAt(0));
    }
}
