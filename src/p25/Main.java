package p25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1051
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(110000);

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(in.readLine());
        char[] chars = in.readLine().toCharArray();
        in.close();
        int[] numbers = new int[N+1];//必须为N+1 ，是N的话会报错
        int num = 0;
        int index = 0;
        for (char aChar : chars) {
            if (aChar != ' ') {
                num = num * 10 + aChar - 48;
            }
            if (aChar == ' ') {
                numbers[index++] = num;
                num = 0;
            }
        }
        numbers[index] = num;
        Arrays.sort(numbers);
        int n = 1;
        int m = N;
        int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            if (N % i == 0) {
                n = i;
                m = N / n;
            }
        }

        int[][] results = new int[m][n];
        int i = numbers.length;
        int x = -1;
        int y = 0;
        while (i > 1) {
            while (x < n - 1 && results[y][x + 1] == 0) {
                results[y][++x] = numbers[--i];
            }
            while (y < m - 1 && results[y + 1][x] == 0) {
                results[++y][x] = numbers[--i];
            }
            while (x > 0 && results[y][x - 1] == 0) {
                results[y][--x] = numbers[--i];
            }
            while (y > 0 && results[y - 1][x] == 0) {
                results[--y][x] = numbers[--i];
            }
        }

        for (int[] result : results) {
            for (int r : result) {
                sb.append(r).append(' ');
            }
            sb.setCharAt(sb.length() - 1, '\n');
        }
        sb.setCharAt(sb.length() - 1, '\n');
        System.out.print(sb.toString());
    }
}

