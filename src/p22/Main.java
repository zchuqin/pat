package p22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1048
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static char[] getChars1 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K', '0', '1', '2', '3', '4', '5'};

    private final static char[] getChars2 = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) throws IOException {
        char[] chars = in.readLine().toCharArray();
        in.close();
        int j = -1;
        int offset = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (j < 0) {j = i;}
            } else if (j >= 0) {
                offset = i;
                break;
            }
        }
        int i = chars.length;
        int count = Math.max(j, i - offset);
        boolean flag = true;
        while (--j >= 0 && --i >= offset) {
            if (flag) {
                chars[i] = getChars1[chars[i] + chars[j] - 96];
                flag = false;
            } else {
                chars[i] = getChars2[chars[i] - chars[j] + 9];
                flag = true;
            }
        }
        j++;
        while (--j >= 0) {
            if (flag) {
                chars[i--] = getChars1[chars[j] - 48];
                flag = false;
            } else {
                chars[i--] = getChars2[57 - chars[j]];
                flag = true;
            }
        }
        System.out.println(new String(chars, chars.length - count, count));
    }
}

