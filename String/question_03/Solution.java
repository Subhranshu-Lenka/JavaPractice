import java.util.Scanner;

class Solution {

    public static boolean isValidRoman(String s) {
    if (s == null || s.isEmpty()) return false;

    // Roman numerals can only use these characters
    if (!s.matches("^[IVXLCDM]+$")) return false;

    // Strict Roman numeral validation using regex
    // Covers subtractive rules like IV, IX, XL, XC, CD, CM
    String romanRegex = 
        "^M{0,3}" +                 // Thousands - 0 to 3000
        "(CM|CD|D?C{0,3})" +        // Hundreds - 900 (CM), 400 (CD), 0-300 (C, CC, CCC)
        "(XC|XL|L?X{0,3})" +        // Tens - 90 (XC), 40 (XL), 0-30 (X, XX, XXX)
        "(IX|IV|V?I{0,3})$";        // Ones - 9 (IX), 4 (IV), 0-3 (I, II, III)

    return s.matches(romanRegex);
}

    public static int value(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;  
        }
    }
    public static int romanToInt(String s) {
        s = s.toUpperCase();
        int sum = 0;
        int length = s.length();

        for(int i=0;i<length;i++){
            int currValue = value(s.charAt(i));

            if(i+1 < length && currValue < value(s.charAt(i+1))){
                sum-=currValue;
            }
            else{
                sum+=currValue;
            }
        }
        return sum;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter you roman string / roman number.");
        String s = sc.nextLine().trim().toUpperCase();

        if(!isValidRoman(s)){
            System.out.println("Invalid Roman Literal. Quiting the program ...");
            return;
        }

        
    
        // now here you can add more arrangement validations and checks

        int result = romanToInt(s);

        System.out.println("The computed value of your roman number is :  "+result);
    }
}