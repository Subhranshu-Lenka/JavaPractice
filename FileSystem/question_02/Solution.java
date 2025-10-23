import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path. Please select only text files for output.");
        String inputPath = sc.nextLine().trim();

        try{
            BufferedReader br = new BufferedReader(new FileReader(inputPath));
            Map<String, Integer> freq = new HashMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                for (String word : line.split("\\s+")) {
                    if (!word.isEmpty()) freq.put(word, freq.getOrDefault(word, 0) + 1);
                }
            }
            br.close();
            freq.forEach((k, v) -> System.out.println(k + " - " + v));
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
