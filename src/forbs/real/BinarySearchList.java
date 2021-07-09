package forbs.real;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearchList {

    private static void binarySearch(List<Integer> integerList, int searchNum) {
        if(integerList.size() == 0)
            return;
        System.out.println(integerList.size()/2);
        int comparision = integerList.get(integerList.size()/2);

        if(comparision == searchNum){
            int index = integerList.indexOf(comparision);
            System.out.println(index + "요소에 있음");
            return;
        }

        if(searchNum > comparision){ //검색값이 기준값보다 큰 경우
            //subList(포함, 뒤에미포함)
            //subList 를 무분별하게 사용하지 말자. 부모가 바뀌면 영향을 줘
            List<Integer> subList = new ArrayList<>(integerList.subList(integerList.size()/2, integerList.size()));
            binarySearch(subList, searchNum);
        }else{
            //검색값이 기준값보다 작은 경우
            List<Integer> subList = new ArrayList<>(integerList.subList(0,integerList.size()/2));
            binarySearch(subList, searchNum);
        }

    }

    public static void main(String[] args) {
        List<Integer>integerList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        for(int i=0; i<size; i++) {
            int num = sc.nextInt();
            integerList.add(num);
        }

        System.out.print("찾을 숫자 입력 : ");
        int searchNum = sc.nextInt();


        binarySearch(integerList,searchNum);

    }

}
