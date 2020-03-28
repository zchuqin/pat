package p13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1039
public class Main {
    private static final int[] counts = new int[128];


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = in.readLine().toCharArray();
        char[] chars1 = in.readLine().toCharArray();
        in.close();
        for (char c : chars) {
            counts[c]++;
        }
        for (char c : chars1) {
            counts[c]--;
        }
        int addtion = 0;
        int subtract = 0;
        for (int i = 65; i < 91; i++) {
            if (counts[i] > 0) {
                addtion += counts[i];
            }
            if (counts[i] < 0) {
                subtract -= counts[i];
            }
        }
        for (int i = 97; i < 123; i++) {
            if (counts[i] > 0) {
                addtion += counts[i];
            }
            if (counts[i] < 0) {
                subtract -= counts[i];
            }
        }
        for (int i = 48; i < 58; i++) {
            if (counts[i] > 0) {
                addtion += counts[i];
            }
            if (counts[i] < 0) {
                subtract -= counts[i];
            }
        }
        if (subtract == 0) {
            System.out.print("Yes ");
            System.out.println(addtion);
        } else {
            System.out.print("No ");
            System.out.println(subtract);
        }

    }
}
