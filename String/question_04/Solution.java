import java.util.Scanner;
import java.util.HashMap;

class Solution{
    
    public static String Longest_Substring_Without_Repeating_Characters(String str){
        int n = str.length();
        HashMap<Character,Integer> charMap = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        String subStr="";

        for(int i=0; i<n; i++){
            char c= str.charAt(i);

            if(charMap.containsKey(c) && charMap.get(c)>=left){
                left = charMap.get(c)+1;
            }

            charMap.put(c,i);

            int currLen = i - left + 1;

            if(currLen>maxLen){
                maxLen = currLen;
                subStr = str.substring(left,i+1);
            }
        }

        return subStr;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String.");
        String s = sc.nextLine().trim();

        String result = Longest_Substring_Without_Repeating_Characters(s);
        System.out.printf("substring = '%s', size = %d",result, result.length());
    }
}