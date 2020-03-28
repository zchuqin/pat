package p33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1064
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(1000);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            split(map,in.readLine().toCharArray());
        }
        int m = Integer.parseInt(in.readLine());
        Integer[] ints = split(in.readLine().toCharArray(), m);
        HashSet<Integer> set = new HashSet<>(Arrays.asList(ints));
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i : ints) {
            if (!map.containsKey(i)) {
                integers.add(i);
            } else {
                Integer value = map.get(i);
                if (!set.contains(value)) {
                    integers.add(i);
                }
            }
        }
        if (integers.size() > 0) {
            Collections.sort(integers);
            sb.append(integers.size()).append('\n');
            for (Integer integer : integers) {
                sb.append(integer).append(' ');
            }
            sb.setCharAt(sb.length() - 1, '\n');
            System.out.print(sb.toString());
        } else {
            System.out.println(0);
        }
    }

    private static void split(Map<Integer, Integer> map, char[] src) {
        int i1 = (((((src[0] - 48) * 10) + src[1] - 48) * 10 + src[2] - 48) * 10 + src[3] - 48) * 10 + src[4] - 48;
        int i2 = (((((src[6] - 48) * 10) + src[7] - 48) * 10 + src[8] - 48) * 10 + src[9] - 48) * 10 + src[10] - 48;
        map.put(i1, i2);
        map.put(i2, i1);
    }

    private static Integer[] split(char[] src, int n) {
        Integer[] ints = new Integer[n];
        for (int i = 0, j, k, l = 0; i < src.length; i += 2) {
            k = src[i] - 48;
            for (j = 1; j < 5; j++) {
                k *= 10;
                k += src[++i];
                k -= 48;
            }
            ints[l++] = k;
        }
        return ints;
    }
}



