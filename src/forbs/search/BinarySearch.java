package forbs.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 1,4,5,6,7,9,13,22 -> 에서 9를 검색하라
 *
 * */

public class BinarySearch {

    static List<Integer> integers = new ArrayList<>();
    static int[] orginArr = {1,4,5,6,7,9,13,22};

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int searchValue = sc.nextInt();

        Arrays.sort(orginArr); //정렬 강제로 다시! 강제성 부여

        List<Integer> integerList = new ArrayList<>();
        for (int j : orginArr) {
            integerList.add(j);
        }

        integers = integerList; //전역변수로 관리하기 위함 -> 쪼개진 리스트들만이 다니니까
        bsearchList(searchValue,integerList);

        bsearchArr(searchValue,orginArr);

    }

    //list로 binary Search를 구현한다.
    private static void bsearchList(int searchValue, List<Integer> list) {
        int comparision = list.get(list.size()/2);

        if(comparision == searchValue){
            int index = integers.indexOf(comparision);
            System.out.println(index);
            return;
        }

        if(searchValue > comparision){ //검색값이 기준값보다 큰 경우!?
            List<Integer> subList = new ArrayList<>(list.subList(list.size()/2, list.size()));
            bsearchList(searchValue, subList);
        }else{
            //검색값이 기준값보다 작은 경우
            List<Integer> subList = new ArrayList<>(list.subList(0,list.size()/2));
            bsearchList(searchValue,subList);
        }

    }

    //arr로 binary Search를 구현한다
    private static void bsearchArr(int searchValue,final int[] arr) {

        int min = 0; // 맨 왼쪽 Index
        int max = arr.length - 1; // 맨 오른쪽 Index

        while (min <= max) {
            int mid = (min + max) / 2; // 중간 Index를 구하여 검색한다.
            if (arr[mid] < searchValue) { // 1. 찾는값이 더 큰 경우 우측에서 찾는다.
                min = mid + 1;
            } else if (arr[mid] > searchValue) { // 2. 찾는값이 더 작은 경우 좌측에서
                max = mid - 1;
            } else { // 3. 찾는값을 발견한 경우
                System.out.println("Array Binary Search");
                System.out.println(mid);
                return;
            }
        }
    }



}

