package forbs.sorting.Selection;

public class SelectionSort {
    static int[] arr = {7,3,2,8,9,4,6,1,5};

    public static void main(String[] args) {
        selection_sort(arr, arr.length);
        for(int i : arr){
            System.out.print(i);
        }
    }
    private static void selection_sort(int[] arr, int length) {
        for(int i=0; i < length-1 ; i++){ //총 수행 round는 전체배열의 길이-1 임!
            int minIdx = i; //최소값을 가진 index를 가리킴.
            //최소값을 갖고있는 index를 검색
            for(int j = i+1; j<length; j++){
                //라운드1은 첫번째 인덱스를 의미. 첫번째 인덱스는 포함시키지 않아야하기때문에 j=i+1
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            //i번째 값과 찾은 최소값을 서로 교환
            swap(arr, minIdx, i);
        }
    }

    private static void swap(int[] arr, int minIdx, int i) {
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
}
