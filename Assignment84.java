import java.io.*;
public class Assignment84 {
    public static void main(String[] args) {
        String inputFile1 = "D:/file4.txt";
        String inputFile2 = "D:/file5.txt";
        String outputFile = "D:/combined.txt";
            try (BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
                 BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
            )
            {
                String line;
                while ((line = reader1.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                while ((line = reader2.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("Files merged successfully!");
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
    }
}
