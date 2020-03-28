package p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] chars1 = in.readLine().toCharArray();
        char[] chars2 = in.readLine().toCharArray();
        in.close();
        int len = chars1.length - chars2.length;
        char[] chars = new char[len];
        int index = 0;
        for (int i = 0; i < chars1.length; i++) {
            boolean flag = false;
            char p = upCase(chars1[i]);
            for (int i1 = 0; i1 < chars2.length; i1++) {
                char q = upCase(chars2[i1]);
                if (p == q) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                boolean flag1 = false;
                for (int i1 = 0; i1 < index; i1++) {
                    if (chars[i1] == p) {
                        flag1 = true;
                        break;
                    }
                }
                if (!flag1) {
                    chars[index++] = p;
                }
            }
        }
        System.out.print(new String(chars,0,index));
    }

    private static char upCase(char c) {
        return (c > 96 && c < 123) ? (char) (c - 32) : c;
    }
}
