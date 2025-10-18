import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

class Solution2{
    // Solution in O(n)
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int sub = 0;
        for(int i = 0; i < nums.length; ++i) {
            sub = target - nums[i];
            if(mpp.containsKey(sub))
                return new int[]{mpp.get(sub), i};
            mpp.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);

        String inputRegex = "^\\s*(\\d{1,9})(\\s*,\\s*\\d{1,9})*\\s*$";
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
            System.out.println("The input array is in-corect. Existing the program...");
            return;
        }

        String[] inputs = inputArr.split(",");

        int[] arr = Arrays.stream(inputs)
                    .map(String::trim)  //space removal
                    .mapToInt(Integer::parseInt) // cast to int
                    .toArray();

        System.out.println();
        System.out.println("Given int arr "+ Arrays.toString(arr));
        
        System.out.println();
        System.out.println("Enter the target \t (the specific sum you want to find)");
        int target = sc.nextInt();

        int[] result = twoSum(arr,target);

        System.out.println();
        String message;
        if(result.length>0){
            message = String.format("Target : %d is achieved by adding the elements present at index : %d and %d of the given array.",target,result[0],result[1]);
        }
        else{
            message= String.format("Target : %d cannot be achieved by adding any elements present in the given array.",target);
        }
        System.out.println();
        System.out.println(message);
    }
}