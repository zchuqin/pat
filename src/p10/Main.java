package p10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1035
public class Main {
    private static final char[] chars = new char[20];
    private static final char[] chars1 = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        in.close();
        int n = Integer.parseInt(s[0]);
        int m = n / 2 + n % 2;
        StringBuilder sb = new StringBuilder((n + 1) * m);
        char c = s[1].charAt(0);
        Arrays.fill(chars,c);
        chars1[0] = c;
        chars1[n - 1] = c;
        chars1[n] = '\n';
        sb.append(chars, 0, n).append('\n');
        for (int i = 1; i < m - 1; i++) {
            sb.append(chars1, 0, n + 1);
        }
        sb.append(chars, 0, n);
        System.out.println(sb.toString());
    }
}
