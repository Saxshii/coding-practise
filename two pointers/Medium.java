class Medium{
    //Print int array
    public static void Print(int[] arr){
        int n = arr.length;
        for(int i =0; i<n; i++){ 
            System.out.print(arr[i] + " ");
        }
    }

    // Container with most water
    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int maxWater = 0;
        while(left < right){
            if(height[left] < height[right] ){
                maxWater = Math.max(maxWater, ( height[left] * (right - left) ));
                left++;
            }else{
                maxWater = Math.max(maxWater, ( height[right] * (right - left) ));
                right--;
            }
        }
        return maxWater;
    }
    
    //

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(  maxArea(height)  );
    }
}