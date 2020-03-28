package p19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//1044
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(1100000);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        char[] chars = in.readLine().toCharArray();
        in.close();
        int[] numbers = new int[n];
        int num = 0;
        int index = 0;
        boolean[] flags = new boolean[n];
        int max = numbers[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                num = num * 10 + chars[i] - '0';
            }
            if (chars[i] == ' ' || i == chars.length - 1) {
                if (max < num) {
                    max = num;
                    flags[index] = true;
                }
                numbers[index++] = num;
                num = 0;
            }
        }
        int count = 0;
        int min = numbers[n-1] + 1;
        int[] results = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (min > numbers[i]) {
                min = numbers[i];
                if (flags[i]) {
                    results[count++] = numbers[i];
                }
            }
        }
        sb.append(count).append('\n');
        for (int i = count - 1; i >= 0; i--) {
            sb.append(results[i]).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());
    }
}

