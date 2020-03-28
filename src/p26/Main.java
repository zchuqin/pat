package p26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;

//1052
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("utf-8")));

    private final static StringBuilder sb = new StringBuilder(110000);

    private final static String[] strings = new String[11];

    private final static String[][] strs = new String[3][];

    private final static int[] strCounts = new int[3];

    private final static int[] toIndexs = { 0, 1, 2, 1, 0};

    private final static String tip = "Are you kidding me? @\\/@\n";

    public static void main(String[] args) throws IOException {
        strs[0] = split(in.readLine().toCharArray());
        strs[1] = split(in.readLine().toCharArray());
        strs[2] = split(in.readLine().toCharArray());
        strCounts[0] = strs[0].length;
        strCounts[1] = strs[1].length;
        strCounts[2] = strs[2].length;

        int N = Integer.parseInt(in.readLine());
        int num = 0;
        int index = 0;
        boolean flag;
        StringBuilder sb1 = new StringBuilder(25);
        for (int i = 0; i < N; i++) {
            flag = true;
            num = 0;
            index = 0;
            sb1.delete(0, sb1.length());
            char[] chars = in.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != ' ') {
                    num = num * 10 + chars[j] - 48;
                }
                if (chars[j] == ' ') {
                    if (!setEmoji(sb1, index, num)) {
                        flag = false;
                        break;
                    }
                    index++;
                    num = 0;
                }
            }
            if (flag && setEmoji(sb1, index, num)) {
                sb.append(sb1).append('\n');
            } else {
                sb.append(tip);
            }
        }
        System.out.print(sb.toString());
    }

    private static boolean setEmoji(StringBuilder sb1, int index, int num) {
        int toIndex = toIndexs[index];
        if (num >= strCounts[toIndex] || num < 1) { return false;}
        if (index == 1) {
            sb1.append('(');
        } else if (index == 4) {
            sb1.append(')');
        }
        sb1.append(strs[toIndex][num]);
        return true;
    }

    private static String[] split(char[] chars) {
        int start = -1;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                start = i + 1;
            } else if (chars[i] == ']') {
                strings[count++] = new String(chars, start, i - start);
            }
        }
        String[] strings1 = new String[count + 1];
        System.arraycopy(strings, 0, strings1, 1, count);
        return strings1;
    }
}

