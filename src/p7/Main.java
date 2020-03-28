package p7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1033
public class Main {
    private static final boolean[] keyBoard = new boolean[128];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = in.readLine().toCharArray();
        char[] chars1 = in.readLine().toCharArray();
        in.close();
        for (char c : chars) {
            keyBoard[c] = true;
            if ((c >= 65 && c <= 90)) {
                keyBoard[c + 32] = true;
                continue;
            }
            if (c == '+') {
                for (int i = 65; i < 91 ; i++) {
                    keyBoard[i] = true;
                }
            }
        }
        char[] result = new char[chars1.length];
        int count = 0;
        for (char c : chars1) {
            if (!keyBoard[c]) {
                result[count++] = c;
            }
        }
        System.out.println(String.valueOf(result,0,count));
    }
}
