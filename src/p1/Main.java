package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int c1 = Integer.parseInt(s[0]);
        int c2 = Integer.parseInt(s[1]);
        int i = c2 - c1 + 50;
        int i1 = i / 100;
        int i2 = i1 / 60;
        int i3 = i1 % 60;
        int i4 = i2 / 60;
        int i5 = i2 % 60;
        System.out.printf("%02d:%02d:%02d",i4,i5,i3);
    }
}
