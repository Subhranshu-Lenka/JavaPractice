import java.util.*;

class Solution{

    public static String largestNumber(int[] nums){
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if (strNums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : strNums) 
            sb.append(s);

        return sb.toString();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String inputRegex = "^\\s*(\\d{1,9})(\\s*,\\s*\\d{1,9})*\\s*$";
        
        System.out.println("Enter the positive integer array \n For eg. 1,2,6,3,56,45....");
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

        System.out.println("Input array: "+Arrays.toString(arr));
        String result = largestNumber(arr);
        System.out.println("Result : "+result);
    }
}