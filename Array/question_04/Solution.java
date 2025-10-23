import java.util.Scanner;
import java.util.Arrays;

class Solution{

    public static int[] productExceptSelf(int arr[]){
        int n = arr.length;

        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        int[] result = new int[n];

        prefixProduct[0] = 1;
        for(int i=1; i<n; i++){
            prefixProduct[i] = arr[i-1] * prefixProduct[i-1];
        }

        suffixProduct[n-1]=1;
        for(int j=n-2; j>=0; j--){
            suffixProduct[j] = arr[j+1] * suffixProduct[j+1];
        }

        for(int i=0; i<n; i++){
            result[i] = prefixProduct[i] * suffixProduct[i];
        }

        return result;
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
    
        System.out.println("Input array "+Arrays.toString(arr));

        int result[] = productExceptSelf(arr);

        System.out.println("Result "+Arrays.toString(result));
        
    }
}