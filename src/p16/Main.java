package p16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1042
public class Main {
    private static final int[] counts = new int[128];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = in.readLine().toCharArray();
        in.close();
        for (char aChar : chars) {
            counts[lowCase(aChar)]++;
        }
        int maxCount = -1;
        int maxIndex = -1;
        for (int i = 97; i < 123; i++) {
            if (maxCount < 0) {
                maxCount = counts[i];
                maxIndex = i;
            } else if (maxCount < counts[i]) {
                    maxCount = counts[i];
                    maxIndex = i;
            } else if (maxCount == counts[i]){
                if (maxCount > i) {
                    maxCount = i;
                }
            }
        }
        System.out.print((char)maxIndex);
        System.out.print(' ');
        System.out.println(maxCount);
    }

    private static int lowCase(char c) {
        return (c > 64 && c < 91) ? (c + 32) : c;
    }
}
