package p21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//1046
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static int[] teams = new int[1001];

    private static char[] chars = null;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        int num;
        int teamNo = 0;
        for (int i = 0; i < n; i++) {
            chars = in.readLine().toCharArray();
            num = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != ' ' && chars[j] != '-') {
                    num = num * 10 + chars[j] - '0';
                }
                if (chars[j] == '-') {
                    teamNo = num;
                    num = 0;
                } else if (chars[j] == ' ') {
                    num = 0;
                } else if (j == chars.length - 1) {
                    teams[teamNo] += num;
                }
            }
        }
        in.close();
        num = 0;
        teamNo = 0;
        for (int i = 0; i < teams.length; i++) {
            if (num < teams[i]) {
                teamNo = i;
                num = teams[i];
            }
        }
        System.out.print(teamNo);
        System.out.print(' ');
        System.out.println(num);
    }
}

