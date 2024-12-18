package OtherProjects.hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        // Sử dụng String + toán tử
        long start = System.currentTimeMillis();
        @SuppressWarnings("unused")
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("String concatenation: " + (System.currentTimeMillis() - start) + " ms");

        // Sử dụng StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        System.out.println("StringBuilder concatenation: " + (System.currentTimeMillis() - start) + " ms");

    }
}
