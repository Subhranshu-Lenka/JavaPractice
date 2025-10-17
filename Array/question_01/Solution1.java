import java.util.Scanner;
import java.util.Arrays;

class Solution1{

    public static int[] twoSum(int[] nums, int target){
        int ans[]={};
        
        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans = new int[]{i,j};
                }
            }
        }

        return ans;
    }

    // public static int[] twoSum1(int[] nums, int target) {
    //     Map<Integer, Integer> mpp = new HashMap<>();
    //     int sub = 0;
    //     for(int i = 0; i < nums.length; ++i) {
    //         sub = target - nums[i];
    //         if(mpp.containsKey(sub))
    //             return new int[]{mpp.get(sub), i};
    //         mpp.put(nums[i], i);
    //     }
    //     return new int[]{};
    // }

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);

        String inputRegex = "^\\s*(\\d{1,9})(\\s*,\\s*\\d{1,9})*\\s*$";
        /* valid inputs
           
            "123, 456,789",
            "1,2,3",
            "  12 , 34 , 56  "
        */ 

        System.out.println("Enter the integer array \n For eg. 1,2,6,3,56,45....");
        String inputArr = sc.nextLine();

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

        System.out.println("Given int arr "+ Arrays.toString(arr));
        
        
        System.out.println("Enter the target \t (the specific sum you want to find)");
        int target = sc.nextInt();

        // Any result = twoSum()

    }
}