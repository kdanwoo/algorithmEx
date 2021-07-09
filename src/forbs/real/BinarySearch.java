package forbs.real;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {

    static int[] a;

    private static void binarySearch(int searchNum) {
        List<Integer> integerList = new ArrayList<>();

        for(int i=0; i<a.length; i++){
            integerList.add(a[i]);
        }

        int index = Collections.binarySearch(integerList, searchNum);
        System.out.println(index);


    }

    public static void main(String[] args) {
        a = new int[]{1, 2, 7, 9, 17, 18, 23};
        Scanner sc = new Scanner(System.in);
        int searchNum = sc.nextInt();

        binarySearch(searchNum);

    }


}
