import java.util.Scanner;
import java.util.Arrays;

class Solution1{

    public static int maximumSubArraySum(int[] arr){
        int res = arr[0];

        // naive appraoch O(n^2)
        for(int i=0;i<arr.length ; i++){
            int currSum = 0;

            for(int j=i;j<arr.length;j++){
                currSum += arr[j];

                res = Math.max(currSum,res);
            }
        }

        return res;

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String inputRegex = "^\\s*(-?\\d{1,9})(\\s*,\\s*-?\\d{1,9})*\\s*$";
        /* valid inputs
            "123, 456,789",
            "1,2,3",
            "  12 , 34 , 56  "
        */ 

        System.out.println();
        System.out.println("Enter the integer array \n For eg. 1,2,6,3,56,45....");

        String inputArr = sc.nextLine();

        System.out.println();
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


        int result = maximumSubArraySum(arr);

        System.out.println("The maximum sub-array sum is : "+result);
    }
}