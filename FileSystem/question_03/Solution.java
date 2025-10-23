import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the string you want to append to a file.");
        String inputStr = sc.nextLine().trim();
        
        System.out.println("Enter the file path where you want to append. Please select only text files for output.");
        String inputPath = sc.nextLine().trim();

        try{
            FileWriter fw = new FileWriter(inputPath, true); // true → append mode
            fw.write(inputStr + "\n");
            fw.close();
            System.out.println("Data appended successfully.");
        }
        catch(Exception err){
            System.out.println("Found errors with the provided file-path.");
            System.out.println(err);
        }
        finally{
            System.out.println("Ending the Program.");
        }
    }
}
