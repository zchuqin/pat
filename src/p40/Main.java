package p40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1072
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(10000);

    public static void main(String[] args) throws IOException {
        int[] ints = split2Int(in.readLine().toCharArray(), ' ', 2);
        int n = ints[0];
        int m = ints[1];
        String name;
        String thing;
        boolean flag;
        int r1 = 0;
        int r2 = 0;
        String[] strings = split(in.readLine().toCharArray(), ' ', m);
        for (int i = 0; i < n; i++) {
            flag = true;
            String[] s = in.readLine().split(" ");
            name = s[0];
            for (int i1 = 2; i1 < s.length; i1++) {
                thing = s[i1];
                if (contains(strings, thing)) {
                    if (flag) {
                        flag = false;
                        sb.append(name).append(':');
                        r1++;
                    }
                    sb.append(' ').append(thing);
                    r2++;
                }
            }
            if (!flag) {
                sb.append('\n');
            }
        }
        sb.append(r1).append(' ').append(r2);
        System.out.println(sb.toString());
    }

    private static boolean contains(String[] src, String aim) {
        for (String s : src) {
            if (s.equals(aim)) {
                return true;
            }
        }
        return false;
    }

    private static int[] split2Int(char[] src, char c, int n) {
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

    private static String[] split(char[] src, char c, int n) {
        String[] results = new String[n];
        int i, j, k = 0, l;
        char[] r;
        for (i = 0, j = 0; i < src.length; i++) {
            if (src[i] == c) {
                l = i - j;
                r = new char[l];
                System.arraycopy(src, j, r, 0, l);
                results[k++] = new String(r);
                j = i + 1;
            }
        }
        if (j < src.length) {
            l = src.length - j;
            r = new char[l];
            System.arraycopy(src, j, r, 0, l);
            results[k] = new String(r);
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



