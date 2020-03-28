package p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int min = 18140906;
    private static final int max = 20140906;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s;
        String minName = null;
        String maxName = null;
        int year;
        int month;
        int date;
        int minYMD = -1;
        int maxYMD = -1;
        int m = 0;
        while (maxName == null && n-- > 0) {
            s = in.readLine().split("[\\s,/]");
            year = Integer.parseInt(s[1]);
            month = Integer.parseInt(s[2]);
            date = Integer.parseInt(s[3]);
            int ymd = year * 10000 + month * 100 + date;
            if (ymd >= min && ymd <= max) {
                minYMD = ymd;
                maxYMD = ymd;
                minName = s[0];
                maxName = s[0];
                m = 1;
                break;
            }
        }
        while (n-- > 0) {
            s = in.readLine().split("[\\s,/]");
            year = Integer.parseInt(s[1]);
            month = Integer.parseInt(s[2]);
            date = Integer.parseInt(s[3]);
            int ymd = year * 10000 + month * 100 + date;
            if (ymd < min || ymd > max) {continue;}
            m++;
            if (ymd < minYMD) {
                minYMD = ymd;
                minName = s[0];
                continue;
            }
            if (ymd > maxYMD) {
                maxYMD = ymd;
                maxName = s[0];
            }
        }
        in.close();
        if (m == 0) {
            System.out.println("0");
        } else {
            System.out.println(String.valueOf(m) + ' ' + minName + ' ' + maxName);
        }
    }
}
