package p31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1063
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(" ");
            int i1 = Integer.parseInt(s[0]);
            int i2 = Integer.parseInt(s[1]);
            int i3 = i1 * i1 + i2 * i2;
            if (max < i3) {
                max = i3;
            }
        }
        System.out.printf("%.02f", Math.sqrt(max));
    }
}



