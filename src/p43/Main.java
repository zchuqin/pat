package p43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1076
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = parseInt(in.readLine().toCharArray());
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = readAnswer();
        }
        System.out.println(chars);
    }

    private static char readAnswer() throws IOException {
        char[] chars = in.readLine().toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == 'T') {
                switch (chars[j-2]) {
                    case 'A':
                        return '1';
                    case 'B':
                        return '2';
                    case 'C':
                        return '3';
                    case 'D':
                        return '4';
                    default:
                        return '0';
                }
            }
        }
        return '0';
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



