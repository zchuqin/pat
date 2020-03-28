package p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1031
public class Main {
    private static final int[] weights = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final char[] zChars = {'1','0','X','9','8','7','6','5','4','3','2'};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            char[] chars = in.readLine().toCharArray();
            if (!verify(chars)) {
                if (flag) {
                    flag = false;
                }
                sb.append(chars).append('\n');
            }
        }
        in.close();
        if (flag) {
            System.out.print("All passed");
        } else {
            System.out.print(sb.toString());
        }
    }

    private static boolean verify(char[] chars) {
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            int c = chars[i] - '0';
            if (c >= 0 && c <= 9) {
                sum += c * weights[i];
            } else {
                return false;
            }
        }
        return zChars[sum % 11] == chars[17];
    }
}
