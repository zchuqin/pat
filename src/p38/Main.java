package p38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1070
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = parseInt(in.readLine().toCharArray());
        Integer[] ints = split(in.readLine().toCharArray(), ' ', n);
        List<Integer> ints1 = Arrays.asList(ints);
        Collections.sort(ints1);
        int result = ints1.get(0);
        for (int i = 1; i < n; i++) {
            result += ints1.get(i);
            result >>= 1;
        }
        System.out.println(result);
    }

    private static Integer[] split(char[] src, char c, int n) {
        Integer[] results = new Integer[n];
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



