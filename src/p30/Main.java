package p30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

//1059
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(100000);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());

        ArrayList<String> list = new ArrayList<>(1024);
        for (int i = 0; i < n; i++) {
            list.add(in.readLine());
        }

        int m = Integer.parseInt(in.readLine());

        for (int i = 0; i < m; i++) {
            
        }
    }
}



