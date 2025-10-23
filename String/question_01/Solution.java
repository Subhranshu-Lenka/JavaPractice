import java.util.Scanner;
import java.util.Arrays;
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        String longest = strs[0];

        for(int i=1;i<strs.length;i++){
            if(longest.length()==0){
                return longest;
            }

            for(int j=0; j<Math.min(longest.length(),strs[i].length()); j++){
                if(longest.charAt(j)!=strs[i].charAt(j)){
                    longest  = longest.substring(0,j);
                    break;
                }
            }
            longest = longest.substring(0,Math.min(longest.length(),strs[i].length()));
        }

        return longest;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String inputRegex = "^\\s*\\w+(\\s*,\\s*\\w+)*\\s*$";
        /* valid inputs
           "apple,banana,cherry" ✅
            "apple, banana, cherry " ✅
            " apple , banana " ✅
        */ 

        System.out.println();
        System.out.println("Enter the string array (comma-separated, optional spaces). \nFor example: apple, banana, cherry");

        String inputArr = sc.nextLine();

        System.out.println();
        if(inputArr.matches(inputRegex)){
            System.out.println("The input array is corect.");
        }
        else{
            System.out.println("The input array is in-corect. Exiting the program...");
            return;
        }

        String[] arr = Arrays.stream(inputArr.split(","))
                        .map(String::trim)
                        .toArray(String[]::new);

        String result = longestCommonPrefix(arr);

        System.out.println();
        System.out.println();
        System.out.println("The most common longest prefix is : '"+result+"'");
    }
}