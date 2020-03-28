package p4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//1030
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        String[] s1 = in.readLine().split(" ");
        int len = s1.length;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(ints);
        int p = Integer.parseInt(s[1]);
        int r = 1;
        int i2 = 2;
        for (int i = len - 1; i >= 0 && i2 > 1; i--) {
            int i1 = (ints[i] - 1) / p + 1;
            i2 = 0;
            for (; i2 <= i; i2++) {
                if (ints[i2] >= i1) {
                    break;
                }
            }
            int i3 = i - i2 + 1;
            if (r < i3) {
                r = i3;
            }
        }
        System.out.println(r);
    }
}
