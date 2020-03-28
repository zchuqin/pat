package p6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1032
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] scores = new int[n];
        int i;
        int count = -1;
        while (n-- > 0) {
            String[] s = in.readLine().split(" ");
            int i1 = Integer.parseInt(s[0]);
            scores[i1] += Integer.parseInt(s[1]);
            if (count < i1) {
                count = i1;
            }
        }
        in.close();
        int k = -1;
        int score = -1;
        for (int j = 0; j <= count; j++) {
            if (score < scores[j]) {
                score = scores[j];
                k = j;
            }
        }
        System.out.print(new StringBuilder(15).append(k).append(' ').append(score).toString());
    }
}
