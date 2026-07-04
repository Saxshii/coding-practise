
import java.util.*;

public class day2 {

    // print 
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // SORT AN ARRAY
    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        print(arr);
    }

    // 3SUM (TRIPLET SUM = ZERO)
    public static List<List<Integer>> tripletSum(int arr[]) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            } //remove duplicate i

            int left = i+1, right = arr.length - 1;
            while (left < right) {
                int Sum = arr[i] + arr[left] + arr[right];

                if (Sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++; right--;
                    // remove same left and right
                    while(left<right && arr[left] == arr[left - 1] ){
                        left++;
                    }
                    while(right>left && arr[right+1] == arr[right]){
                        right--;
                    }
                } else if (Sum < 0) {
                    left++;
                }else {
                    right--;}
            }} 
        return ans;
    }

    // 3SUM CLOSEST TO TARGET
    public static int closestSum(int[] arr, int target){
        int n = arr.length -1;
        int minDiff = 0;
        int result = 0;

        for(int i=0; i<n-2; i++){
            int left = i+1, right = n-1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == target){
                    return sum;
                }else if(sum < target){
                    int diff = Math.abs(sum - target);
                    minDiff = Math.min(diff, minDiff);
                    result = sum; left++;
                }else{
                    int diff = Math.abs(sum - target);
                    minDiff = Math.min(diff, minDiff);
                    result = sum; right--;
                }
            }
        } 
        return result;
    }
    
    //3SUM WITH SMALLER SUM
    // public static void smallerSum(int[] arr, int target){
    //     int n = arr.length;
    //     for(int i=0; i<n-2; i++){
    //         int left = i+1, right = n-1;
            
    //         while(left < right){
    //             int sum = arr[i] + arr[left] + arr[right];
    //             if(sum >= target){
    //                 l++;
    //             }
    //         }
    //     }
    // }

    // SWAP - HELPING FNC
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // DUTCH NATIONAL FLAG
    public static void dutchNationalFlag(int[] arr){
        int n = arr.length;
        int low = 0, mid = 0, high = n-1;
        while(mid<= high){
            if(arr[mid] == 1){
                mid++;
            }else if( arr[mid] == 0){
                swap(arr, mid, low);
                low++; mid++;
            }else{
                swap(arr, mid, high);
                high--;
            }
        }
        print(arr);
    }

    public static void main(String[] args) {
        // int triplet[] = {-1, 0, 1, 2, -1, -4};
        // System.out.println( tripletSum(triplet) );

        // int closest[] = {-1,2,1,-4};
        // System.out.println( closestSum(closest, 1) );

        // int smaller[] = {-2,0,1,3};
        // smallerSum(smaller, 1);

        // int test[] = {0,1,5,3,4,2};
        // swap(test, 2, 5);

        int number[] = {2,0,2,1,1,0};
        dutchNationalFlag(number);


    }
}
