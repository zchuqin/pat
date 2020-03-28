package p39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1071
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] s = split(in.readLine().toCharArray(), ' ', 2);
        int t = s[0];
        int n = s[1];
        for (int i = 0; i < n; i++) {
            int[] s1 = split(in.readLine().toCharArray(), ' ', 4);
            if (s1[2] > t) {
                System.out.println("Not enough tokens.  Total = " + t + ".");
            } else {
                boolean b = s1[1] > 0 ^ s1[3] < s1[0];
                if (b) {
                    t += s1[2];
                    System.out.println("Win " + s1[2] + "!  Total = " + t + ".");
                } else {
                    t -= s1[2];
                    System.out.println("Lose " + s1[2] + ".  Total = " + t + ".");
                    if (t == 0) {
                        System.out.println("Game Over.");
                        break;
                    }
                }
            }
        }
    }

    private static int[] split(char[] src, char c, int n) {
        int[] results = new int[n];
        int i, j, k = 0, l;
        for (i = 0, j = 0; i < src.length; i++) {
            if (src[i] == c) {
                l = i - j;
                char[] r = new char[l];
                System.arraycopy(src, j, r, 0, l);
                results[k++] = parseInt(r);
                j = i + 1;
            }
        }
        if (j < src.length) {
            l = src.length - j;
            char[] r = new char[l];
            System.arraycopy(src, j, r, 0, l);
            results[k] = parseInt(r);
        }
        return results;
    }

    private static int parseInt(char[] src) {
        int j = src[0] - 48;
        for (int i = 1; i < src.length; i++) {
            j = (j << 3) + (j << 1);
            j += src[i];
            j -= 48;
        }
        return j;
    }
}



