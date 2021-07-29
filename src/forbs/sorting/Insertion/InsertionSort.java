package forbs.sorting.Insertion;

/**
 * 1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다. (첫 번째 타겟은 두 번째 원소부터 시작한다.)
 * 2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작다면 위치를 서로 교환한다.
 * 3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다.
 * */
public class InsertionSort {

    static int[] arr = {7,3,2,8,9,4,6,1,5};

    public static void main(String[] args) {
        inserstionSort(arr, arr.length);
        for(int i : arr){
            System.out.print(i);
        }
    }
    //삽입정렬
    private static void inserstionSort(int[] arr, int length) {
        for(int i=1 ; i<length; i++){
            //두번째서부터 비교를 해야함!
            int target = arr[i];

            int j = i-1; //이전꺼랑 비교하기 위해서

            while(j>=0 && target < arr[j]){
                //타겟이 이전원보다 크기전까지 반복
                arr[j+1] = arr[j]; //이전 원소를 한칸씩 뒤로 미룬다.
                j--;
            }
            /**
             * 위의 반복문에서 탈출하거나, 위의 반복문이 수행되지 않는 경우는!
             * 앞의 원소가 타켓보다 작다는 의미다!
             * 타겟 원소는 j번째 원소뒤에 위치하고 있다!
             * 그럼으로 타겟은 j+1에 위치한다.
             * */
            arr[j+1] = target;
        }
    }

}
