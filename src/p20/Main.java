package p20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1046
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(1100000);

    private static char[] chars = null;

    private static int[] numbers = new int[4];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        int num;
        int index;
        int n1 = 0;
        int n2 = 0;
        for (int j = n; j > 0; j--) {
            chars = in.readLine().toCharArray();
            index = 0;
            num = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') {
                    num = num * 10 + chars[i] - '0';
                }
                if (chars[i] == ' ' || i == chars.length - 1) {
                    numbers[index++] = num;
                    num = 0;
                }
            }
            int sum = numbers[0] + numbers[2];
            if (numbers[1] == sum) {
                if (numbers[3] != sum) {
                    n2++;
                }
            } else if (numbers[3] == sum) {
                n1++;
            }
        }
        System.out.print(n1);
        System.out.print(' ');
        System.out.println(n2);
    }
}

