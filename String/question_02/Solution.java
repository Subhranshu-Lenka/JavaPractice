import java.util.Scanner;
import java.util.HashMap;

class Solution{
    public static boolean checkAnagram(String str1, String str2){
        
        if(str1.length() != str2.length()) return false;
        
        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(char ch : str1.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }

        for(char ch : str2.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)-1);
        }

        for(var data : freqMap.entrySet()){
            if(data.getValue()!=0){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String str1,str2;

        System.out.println("Enter the string-1");
        str1 = sc.nextLine().trim().toLowerCase();
        System.out.println("Enter the string-2");
        str2 = sc.nextLine().trim().toLowerCase();
        // System.out.println("Input String "+str1+" "+str2);

        boolean result = checkAnagram(str1,str2);
        System.out.println(result);
        System.out.printf("Given two strings '%s', '%s' %s%s", str1, str2, result ? "are" : "are not", " Anagram");

        return;
    }
}