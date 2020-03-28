package p15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1041
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] orders = new int[n+1];
        char[][] strings = new char[n+1][];
        for (int i = 0; i < n; i++) {
            char[] chars = in.readLine().toCharArray();
            int index = 0;
            int j = 17;
            while (true){
                if (chars[j] != ' ') {
                    index = index * 10 + chars[j] - 48;
                } else {
                    break;
                }
                j++;
            }
            orders[index] = j;
            strings[index] = chars;
        }
        in.readLine();
        String[] s = in.readLine().split(" ");
        in.close();
        StringBuilder sb = new StringBuilder(n * 24);
        int i, j;
        for (String s1 : s) {
            i = Integer.parseInt(s1);
            j = orders[i];
            char[] chars = strings[i];
            sb.append(chars, 0, 16).append(chars, j, chars.length - j).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
