
public class basics {

    // print arr
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    // swap:
    // int temp = arr[j];
    // arr[j] = arr[i];
    // arr[i] = temp;

    // Sorted Array , REMOVE DUPLICATES
    public static void removeDuplicate(int[] arr) {
        int p1 = 0, p2 = 1;
        while (p2 < arr.length) {
            if (arr[p2] != arr[p1]) {
                p1++;
                arr[p1] = arr[p2];
            }
            p2++;
        }
        for (int i = p1 + 1; i < arr.length; i++) {
            arr[i] = 0;
        }
        print(arr);
    }

    // SEPERATE 0 N 1. ZERO IN LEFT ANF 1 TO RIGHT.
    public static void moveZeroOnes(int arr[]) {
        int p1 = 0, p2 = arr.length - 1;
        if (arr.length == 0) return;

        while (p1 < p2) {
            
            if (arr[p1] == 0) {
                p1++; 
            }else if (arr[p2] == 1) {
                p2--; 
            }else {
                int temp = arr[p2];
                arr[p2] = arr[p1];
                arr[p1] = temp;
                p1++; p2--;
            }
        }
        print(arr);
    } 

    // Square elements of sorted real no array, arrange in non decreasing
    public static void sortedSquare(int arr[]){
        int p1= 0, p2 = arr.length - 1;
        int k = arr.length - 1;

        int ans[] = new int[arr.length];
        while(p1 < p2){
            int l = arr[p1] * arr[p1];
            int r = arr[p2] * arr[p2];

            if(l > r){
                ans[k] = l;
                k--; p1++;
            }else{
                ans[k] = r;
                k--; p2--;
            }
        }
        print(ans);
    }

    public static void main(String args[]) {
        int duplicate[] = {1, 1, 1, 2, 2, 3, 3, 3};
        removeDuplicate(duplicate);
        System.out.println("");

        int zerone[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        moveZeroOnes(zerone);
        System.out.println("");

        int square[] = {-4, -1, 0 , 3, 10};
        sortedSquare(square);
    }
}
