package p32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1064
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(1000);

    private final static int[] ints = new int[10001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        char[][] split = split(in.readLine().toCharArray(), ' ', n);
        HashSet<Integer> integers = new HashSet<>();
        for (char[] chars : split) {
            int r = 0;
            for (char aChar : chars) {
                r += aChar;
                r -= '0';
            }
            integers.add(r);
        }
        if (integers.size() > 0) {
            ArrayList<Integer> list = new ArrayList<>(integers);
            Collections.sort(list);
            sb.append(list.size()).append('\n');
            for (Integer integer : list) {
                sb.append(integer).append(' ');
            }
            sb.setCharAt(sb.length() - 1, '\n');
            System.out.print(sb.toString());
        } else {
            System.out.println(0);
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
}



