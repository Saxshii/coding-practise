public class basics{
    // print arr
    public static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    // Sorted Array , REMOVE DUPLICATES
    public static void removeDuplicate(int[] arr){
        int p1 = 0, p2 = 1;
        while(p2 < arr.length){
            if(arr[p2] != arr[p1]){
                p1++;
                arr[p1] = arr[p2];
                
            }
            p2++;
        }
        for(int i = p1+1; i<arr.length; i++){
            arr[i] = 0;
        }
        print(arr);
    }

    // SEPERATE 0 N 1. ZERO IN LEFT ANF 1 TO RIGHT.

    public static void main(String args[]){
        int duplicate[] = {1,1,1,2,2,3,3,3};
        removeDuplicate(duplicate);

        int zerone[] = {0,1,0,1,0,0,1,1,1,0};
    }
}