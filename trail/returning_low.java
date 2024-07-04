// checking how returning low is actually giviing the ans '7' instead of going lower than 7

package trail;

public class returning_low {
    public static void main(String[] args) {
        int[] arr = {3,4,5,7,8,9,7};
        System.out.println(find(arr, 6));
    }

    static int find(int[] arr, int k) {
        int low = 0, high = arr.length;
        while (low <= high) {
            int mid = (low + high)/2;
            System.out.println(arr[mid]);
            if (arr[mid] > 6){
                high = mid -1;
            }
            else low = mid + 1;
            System.out.println(arr[low]+","+arr[mid]+","+arr[high]);
        }
        return  arr[low];
    }
}
