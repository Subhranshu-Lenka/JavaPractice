import java.util.Scanner;
import java.util.*;

class Solution{

    public static List<Integer> selfDividingNumbers(int left,int right){
        List<Integer> arr = new ArrayList<>();

        for(int num = left; num<=right; num++){

            if (num % 10 == 0 || num % 100 == 0 || num % 1000 == 0)
            continue;

            if(num>0 && num<10){
                arr.add(num);
                continue;
            }

            int temp = num;
            boolean flag = true;
            while(temp!=0){
                int digit = temp%10;

                if(digit==0 || num%digit!=0){
                    flag = false;
                    break;
                }

                temp = temp/10;
            }

            if(flag){
                arr.add(num);
            }
        }

        return arr;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 'left' starting integer.");
        int left = sc.nextInt();

        System.out.println("Enter 'right' ending integer.");
        int right = sc.nextInt();

        List<Integer> result = selfDividingNumbers(left,right);

        System.out.println("result "+ result);

    }
}