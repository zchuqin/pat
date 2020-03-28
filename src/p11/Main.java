package p11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1037
public class Main {
    private static final long p = 493;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = in.readLine().toCharArray();
        in.close();
        char[][] split = split(chars, '.', 5);
        char[][] split1 = split(split[2], ' ', 2);
        long i1 = Long.parseLong(new String(split[0]));
        long i2 = Long.parseLong(new String(split[1]));
        long i3 = Long.parseLong(new String(split1[0]));
        long i4 = Long.parseLong(new String(split1[1]));
        long i5 = Long.parseLong(new String(split[3]));
        long i6 = Long.parseLong(new String(split[4]));
        long m = i4 * p + i5 * 29 + i6;
        long n = i1 * p + i2 * 29 + i3;
        long l = m - n;
        StringBuilder sb = new StringBuilder();
        if (l < 0) {
            sb.append('-');
            l = -l;
        }
        long l1 = l % p;
        System.out.println(sb.append(l / p).append('.').append(l1 / 29).append('.').append(l1 % 29).toString());
    }

    private static char[][] split(char[] src, char c, int n) {
        char[][] results = new char[n][];
        int i, j, k = 0, l;
        for (i = 0, j = 0; i < src.length; i++) {
            if (src[i] == c) {
                l = i - j;
                results[k] = new char[l];
                System.arraycopy(src, j, results[k++], 0, l);
                j = i + 1;
            }
        }
        if (j < src.length) {
            l = src.length - j;
            results[k] = new char[l];
            System.arraycopy(src, j, results[k], 0, l);
        }
        return results;
    }
}
