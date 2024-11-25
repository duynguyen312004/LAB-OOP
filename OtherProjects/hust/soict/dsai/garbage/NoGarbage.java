package OtherProjects.hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws Exception {
        String filename = "C:\\Users\\ADMIN\\Downloads\\Documents\\large_file.txt"; // Đường dẫn file lớn
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        @SuppressWarnings("unused")
        String outputString = outputStringBuilder.toString();
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken with StringBuilder: " + (endTime - startTime) + " ms");
    }
}
