class Day1{
    // print int arr
    public static void print(int arr[]){
        int n = arr.length;
        for(int i =0; i<n; i++){ 
            System.out.print(arr[i] +" ");
        }
    }

    // print String array
    public static void print(String[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    // Maximum avg subarray of size k - FIXED
    public static float maximumAvg(int[] arr, int k){
        int n = arr.length;
        int start = 0, end = k-1;
        int sum = 0;
        float maxAvg = Integer.MIN_VALUE;
        
        // first wind
        for(int i =start; i<= end;i++){
            sum += arr[i];
        }
        // rest window
        while(end < n){
            float avg = (float) sum / k;
            maxAvg = Math.max(maxAvg, avg);
            start++; end++;
            sum -= arr[start-1];
            if(end == n) break;
            sum += arr[end];
        }
        return maxAvg;
    }

    // Minimum length of subaaray whose sum >= target - VARIABLE
    public static int minimumLength(int[] arr, int target){
        int start = 0, end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while(end < arr.length){
            sum += arr[end];
            while(sum >= target){
                int len = end - start; //window size
                result = Math.min(result, len); //min window size
                sum -= arr[start];
                start++; //shrink
            }
            end++;
        }
        return result+1;
    }

    public static void main(String args[]){
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(maximumAvg(nums, 4));

        int arr[] = {1,2,4,4};
        System.out.println( minimumLength(arr, 5) );
    }
}