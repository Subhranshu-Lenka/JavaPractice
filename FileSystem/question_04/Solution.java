import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word that you want to find & replace");
        String findStr = sc.nextLine().trim();
        
        System.out.println("Enter the word that you want to replace with");
        String replaceStr = sc.nextLine().trim();
        
        System.out.println("Enter the file path. Please select only text files for output.");
        String inputPath = sc.nextLine().trim();
        
        try{
            String content = new String(Files.readAllBytes(Paths.get(inputPath)));
            content = content.replaceAll(findStr, replaceStr);
            Files.write(Paths.get("output.txt"), content.getBytes());
            System.out.println("Replacements done.");
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
