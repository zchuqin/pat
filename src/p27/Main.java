package p27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1053
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        double e = Double.parseDouble(s[1]);
        int D = Integer.parseInt(s[2]);
        int count;
        int r1 = 0;
        int r2 = 0;
        for (int i = 0; i < N; i++) {
            count = 0;
            String[] s1 = in.readLine().split(" ");
            int k = Integer.parseInt(s1[0]);
            for (int j = 1; j < s1.length; j++) {
                if (Double.parseDouble(s1[j]) < e) {
                    count++;
                }
            }
            if (count > k / 2) {
                if (k > D) {
                    r1++;
                } else {
                    r2++;
                }
            }
        }
        System.out.printf("%.1f%% %.1f%%", r2 * 100.0 / N, r1 * 100.0 / N);
    }
}



