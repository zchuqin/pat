package p23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1049
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        char[] chars = in.readLine().toCharArray();
        in.close();
        double[] doubles = new double[n];
        int offset = 0;
        int count;
        int index = 0;
        int i;
        for (i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count = i - offset;
                doubles[index++] = Double.valueOf(new String(chars, offset,count));
                offset = i + 1;
            }
        }
        count = i - offset;
        doubles[index] = Double.valueOf(new String(chars, offset,count));

        double result = 0.0;
        int j = 0, k = n - 1;
        for (; j < n / 2; j++, k--) {
            double v = (doubles[j] + doubles[k]) * (j + 1) * (k + 1);
            result += v;
        }
        if (j == k) {
            double v = doubles[j] * (j + 1) * (k + 1);
            result += v;
        }
        System.out.printf("%.2f",result);
    }
}

