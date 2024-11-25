package OtherProjects.hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "C:\\Users\\ADMIN\\Downloads\\Documents\\large_file.txt"; // Đường dẫn file lớn
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();
        @SuppressWarnings("unused")
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken with String concatenation: " + (endTime - startTime) + " ms");
    }
}
