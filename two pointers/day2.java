import java.util.*;
public class day2{
    // print 
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // SORT AN ARRAY
    public static void sort(int arr[]){
        int n = arr.length;
        for(int i = 0; i<n-1; i++){ 
            for(int j = i+1; j<n; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        print(arr);
    }

    // 3SUM (TRIPLET SUM = ZERO)
    public static List<List<Integer>> tripletSum(int arr[]){
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        sort(arr);
        for(int i =0; i<n-2; i++){
            int left = i+1, right = n-1;

            while(left < right){  //2SUM
            int sum = -(arr[i]); //TARGET

            if(arr[left] + arr[right] == sum){
                ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
                left++; right--;
            }else if( arr[left] + arr[right] < sum){
                left++;
            }else{
                right--;
            }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int triplet[] = {-1,0,1,2,-1,-4};
        tripletSum(triplet);

        
    }
}
