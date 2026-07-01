class Practise{
    //  print int array
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //  print char array
    public static void print(char[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    // LC - 125 VALID PALINDROME
    public static boolean isPalindrome(String s) {
        char arr[] = s.toCharArray();
            int left = 0;
            int right = arr.length-1;

            while(left < right){
                if(!Character.isLetterOrDigit(arr[left])){
                    left++;
                }else if( !Character.isLetterOrDigit(arr[right]) ) {
                    right--;
                }else{
                    if(Character.toLowerCase(arr[left]) == Character.toLowerCase(arr[right])){
                        left++; right--;
                    }else{
                        return false;
                    }
                }
            }
        return true;
    }

    // LC - 344 Reverse a string
    public static void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;r--;
        }
        print(s);
    }
    
    // LC - 167 2sum - II
    public static int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            if(  (arr[left] + arr[right]) > target ){
                right--;
            }else if( (arr[left] + arr[right]) < target ){
                left++;
            }else{
                return new int[]{left+1, right+1};
            }
        }
        return new int[]{-1,-1};
    }

    // LC - 283 Move Zeroes and preserve order of non zero
    public static void moveZeroes(int[] arr) {
        int l = 0; int r = l +1;
        while(r < arr.length){
            if( arr[l] != 0 ) l++;
            else if(arr[r] == 0 ) r++;
            else{
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                r++;l++;
            }
        }
        print(arr);
    }


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        char str[] = {'h', 'e', 'l', 'l', 'o'};
        reverseString(str);
        System.out.println("");

        int[] zeroes = {0,1,0,3,12};
        moveZeroes(zeroes);
        System.out.println("");

        int sum[] = {2,7,11,15};
        twoSum(sum, 9);
    }
}
