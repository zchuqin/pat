package p34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1066
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            char[][] split = split(in.readLine().toCharArray(), ' ', 5);
            int n = parseInt(split[0]);
            int m = parseInt(split[1]);
            for (int i = 0; i < n; i++) {
                System.out.print(split(in.readLine().toCharArray(), ' ', m, doLengthTo3(split[2]), doLengthTo3(split[3]), doLengthTo3(split[4])));
            }
        } catch (IOException e) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
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

    private static char[] split(char[] src, char c, int m,char[] min,char[] max,char[] replace) {
        char[] results = new char[4 * m];
        results[4 * m - 1] = '\n';
        int i, j, k = 0, l;
        char[] r;
        for (i = 0, j = 0; i < src.length; i++) {
            if (src[i] == c) {
                l = i - j;
                r = new char[l];
                System.arraycopy(src, j, r, 0, l);
                r = compareAndSet(r,min,max,replace);
                System.arraycopy(r, 0, results, k, 3);
                results[k + 3] = ' ';
                k += 4;
                j = i + 1;
            }
        }
        if (j < src.length) {
            l = src.length - j;
            r = new char[l];
            System.arraycopy(src, j, r, 0, l);
            r = compareAndSet(r,min,max,replace);
            System.arraycopy(r, 0, results, k, 3);
        }
        return results;
    }

    private static char[] compareAndSet(char[] r, char[] min, char[] max, char[] replace) {
        char[] chars = doLengthTo3(r);
        return compareTo(chars, min) >= 0 && compareTo(max, chars) >= 0 ? replace : chars;
    }

    private static int compareTo(char[] chars1,char[] chars2) {
        for(int i = 0; i < 3; ++i) {
            char c1 = chars1[i];
            char c2 = chars2[i];
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return 0;
    }

    private static char[] doLengthTo3(char[] chars) {
        char[] r;
        switch (chars.length) {
            case 1:
                r = new char[3];
                r[0] = '0';
                r[1] = '0';
                r[2] = chars[0];
                return r;
            case 2:
                r = new char[3];
                r[0] = '0';
                System.arraycopy(chars, 0, r, 1, 2);
                return r;
            default:
                return chars;
        }
    }

    private static int parseInt(char[] src) {
        int j = src[0] - 48;
        for (int i = 1; i < src.length; i++) {
            j *= 10;
            j += src[i];
            j -= 48;
        }
        return j;
    }
}



