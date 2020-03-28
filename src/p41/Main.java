package p41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1074
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] chars = in.readLine().toCharArray();
        char[] chars1 = in.readLine().toCharArray();
        char[] chars2 = in.readLine().toCharArray();
        int length = chars.length;
        int len1 = chars1.length;
        int len2 = chars2.length;
        char[] results = new char[length];
        int d = 0;
        for (int i = length - 1, j = len1 - 1, k = len2 - 1; i >= 0; i--, j--, k--) {
            int r;
            if (j >= 0 && k >= 0) {
                r = chars1[j] + chars2[k] + d - 96;
            } else if (j >= 0) {
                r = chars1[j] + d - 48;
            } else if (k >= 0) {
                r = chars2[k] + d - 48;
            } else if (d > 0) {
                r = d;
            } else {
                break;
            }
            int radix = parseRadix(chars[i]);
            d = r / radix;
            results[i] = (char) (r % radix +48);
        }
        if (d > 0) {
            System.out.print(d);
            System.out.println(results);
        } else {
            int i;
            for (i = 0; i < length; i++) {
                if (results[i] != 0 && results[i] != '0') {
                    break;
                }
            }
            if (i == length) {
                System.out.println('0');
            } else {
                char[] chars3 = new char[length - i];
                System.arraycopy(results, i, chars3, 0, length - i);
                System.out.println(chars3);
            }
        }
    }

    private static int parseRadix(char c) {
        switch (c) {
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return 10;
        }
    }
}



