import java.util.*;
class Day2{
    // print int arr
    public static void print(int arr[]){
        int n = arr.length;
        for(int i =0; i<n; i++){ 
            System.out.print(arr[i] +" ");
        }
    }

    // Longest substring with k distinct
    public static int longestDistinct(String s, int k) {

        int n = s.length();
        int left = 0;
        int maxLen = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            // Increase frequency
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink window until distinct characters <= k
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // Update answer only when exactly k distinct characters
            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }

    // LC - FRUIT INTO BASKET
    public static int fruitBasket(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, maxLen = 0;

        for(int end=0; end< arr.length; end++){
            int right = arr[end];
            map.put(right, map.getOrDefault(right, 0) + 1);

            while(map.size() > 2){
                int left = arr[start];
                map.put(left, map.get(left) - 1);
                if(map.get(left) == 0){ map.remove(left); }
                start++;
            }
            // now the baskets having more than 2 frutis already handled so no condition needed
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }

    // LC - Longest substring without repeatition char cters
    public static int longestSubstring(String s ){
        HashSet<Character> set = new HashSet<>();
        int start = 0, maxLen = 0;

        for(int end = 0; end< s.length(); end++){
            char ch = s.charAt(end);

            while(set.contains(ch)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String a = "aabacbebebe";
        System.out.println( longestDistinct(a, 3) );

        int[] fruits = {1,2,3,2,2};
        System.out.println( fruitBasket(fruits) );

        String s = "abcacbeb";
        System.out.println( longestSubstring(s) );
        
    }
}