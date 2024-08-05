import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
public class Assignment81 {
    public void processFiles(List<String> filePaths) {
        for (String filePath : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        List<String> filePaths = List.of("D:/file1.txt", "D:/file2.txt", "D:/file3.txt");
        Assignment81 fileProcessor = new Assignment81();
        fileProcessor.processFiles(filePaths);
    }
}