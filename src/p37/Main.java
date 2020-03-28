package p37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//1069
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(10000);

    public static void main(String[] args) throws IOException {
        String[] split = in.readLine().split("[\\s|\\t]+");
        int m = parseInt(split[0].toCharArray());
        String[] strings = new String[m];
        HashSet<String> stringSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            strings[i] = in.readLine();
        }
        int n = parseInt(split[1].toCharArray());
        int s = parseInt(split[2].toCharArray());
        int i = s - 1;
        while (i < m) {
            if (stringSet.add(strings[i])) {
                sb.append(strings[i]).append('\n');
                i += n;
            } else {
                i++;
            }
        }
        if (sb.length() == 0) {
            sb.append("Keep going...\n");
        }
        System.out.print(sb.toString());
    }

    private static int parseInt(char[] src) {
        int j = src[0] - 48;
        for (int i = 1; i < src.length; i++) {
            j = (j << 3) + (j << 1);
            j += src[i];
            j -= 48;
        }
        return j;
    }
}



