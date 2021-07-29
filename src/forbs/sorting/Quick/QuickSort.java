package forbs.sorting.Quick;

/**
 * 1. 피벗을 하나 선택한다.
 * 2. 피벗을 기준으로 양쪽에서 피벗보다 큰 값, 혹은 작은 값을 찾는다. 왼쪽에서부터는 피벗보다 큰 값을 찾고, 오른쪽에서부터는 피벗보다 작은 값을 찾는다.
 * 3. 양 방향에서 찾은 두 원소를 교환한다.
 * 4. 왼쪽에서 탐색하는 위치와 오른쪽에서 탐색하는 위치가 엇갈리지 않을 때 까지 2번으로 돌아가 위 과정을 반복한다.
 * 5. 엇갈린 기점을 기준으로 두 개의 부분리스트로 나누어 1번으로 돌아가 해당 부분리스트의 길이가 1이 아닐 때 까지 1번 과정을 반복한다. (Divide : 분할)
 * 6. 인접한 부분리스트끼리 합친다. (Conqure : 정복)
 *
 * 피벗을 선택하는 과정은 여러 방법이 있는데, 대표적으로 세 가지가 있다.
 * 현재 부분배열의 가장 왼쪽 원소가 피벗이 되는 방법, 중간 원소가 피벗이 되는 방법, 마지막 원소가 피벗이 되는 방법이다.
 *
 * */
public class QuickSort {
    public static void main(String[] args) {

    }
}