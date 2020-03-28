package p44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1077
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(100000);

    public static void main(String[] args) throws IOException {
        int[] s = split(in.readLine().toCharArray(), ' ', 2);
        int n = s[0];
        int max = s[1];
        for (int i = 0; i < n; i++) {
            sb.append(split(in.readLine().toCharArray(), ' ', n, max)).append('\n');
        }
        System.out.print(sb.toString());
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

    /**
     *  4 50
     * 12 1 2 3
     * 13 2 3 4
     * 14 3 4 5
     * 15 4 5 50
     * @param src
     * @param c
     * @param n
     * @param max
     * @return
     */
    private static int split(char[] src, char c, int n, int max) {
        int[] results = new int[n];
        int i, j, k = 0, l;
        char[] r;
        for (i = 0, j = 0; i < src.length; i++) {
            if (src[i] == c) {
                if (src[j] != '-'){
                    l = i - j;
                    r = new char[l];
                    System.arraycopy(src, j, r, 0, l);
                    int parseInt = parseInt(r);
                    if (parseInt <= max) {
                        results[k++] = parseInt;
                    }
                }
                j = i + 1;
            }
        }
        if (j < src.length) {
            if (src[j] != '-'){
                l = src.length - j;
                r = new char[l];
                System.arraycopy(src, j, r, 0, l);
                int parseInt = parseInt(r);
                if (parseInt <= max) {
                    results[k++] = parseInt;
                }
            }
        }
        int[] ints = new int[k-1];
        System.arraycopy(results, 1, ints, 0, k - 1);
        Arrays.sort(ints);
        int sum = 0;
        for (int x = 1; x < ints.length - 1; x++) {
            sum += ints[x];
        }
        return (int)((sum * 1.0 / (ints.length - 2) + results[0]) / 2+0.5);
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



