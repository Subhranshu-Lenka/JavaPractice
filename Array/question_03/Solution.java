import java.util.Scanner;
import java.util.Arrays;

class Solution{
    public static void merge(int[] arr, int low, int mid, int high){
        int n = mid - low + 1;
        int m = high - mid;

        int left[] = new int[n];
        int right[] = new int[m];
    
        //copy to temp arr
        for(int i = 0; i<n; i++){
            left[i] = arr[low + i];
        }

        for(int i = 0; i<m; i++){
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j=0, k = low;
        while(i< n && j< m){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // residual elements
        while(i<n){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j<m){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    
    public static void mergeSort(int[] arr, int low, int high){
        if(low<high){
            int mid = low + (high-low)/2;

            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);

            merge(arr, low, mid, high);
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String inputRegex = "^\\s*(-?\\d{1,9})(\\s*,\\s*-?\\d{1,9})*\\s*$";
        
        System.out.println("Enter the integer array \n For eg. 1,2,6,3,56,45....");
        String inputArr = sc.nextLine();

        if(inputArr.matches(inputRegex)){
            System.out.println("The input array is corect.");
        }
        else{
            System.out.println("The input array is in-corect. Exiting the program...");
            return;
        }

        int[] arr = Arrays.stream(inputArr.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
    
        System.out.println("Input array before merge sort"+Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println("Input array after merge sort"+Arrays.toString(arr));
    }
}