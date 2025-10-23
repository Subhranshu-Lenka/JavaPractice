import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path. Please select only text files for output.");
        String inputPath = sc.nextLine().trim();

        try{
            BufferedReader br = new BufferedReader(new FileReader(inputPath));
            int lines = 0, words = 0, chars = 0;
            String line;
            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length();
                words += line.split("\\s+").length;
            }
            br.close();
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
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
