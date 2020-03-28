package tools;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;

//1037
public class Main {
    public static void main1(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        char[] chars = s.toCharArray();
        char[][] split = new char[0][];
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
//            split = s.split(" ");
            split = split(chars, ' ', 5);
        }
        System.out.println(System.currentTimeMillis() - l);
        for (char[] chars1 : split) {
            if (chars1 == null) {
                System.out.println("null");
            } else {
                System.out.println(chars1);
            }

        }
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(Double.parseDouble("-.00234"));
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        System.out.println(df.format(12.00));
    }

    public static void main5(String[] args) throws IOException {
        BufferedInputStream bi = new BufferedInputStream(System.in);
        int read = bi.read();
        System.out.println(read);
    }

    public static void main3(String[] args) {
        int a = 0b11111111111111111111111111111111;
        char[] chars = new char[0b11111111111111111111111111111111];
        char[] chars1 = new char[1000000000];
    }

    public static void main4(String[] args) {
        System.out.println('0' - 0);
        System.out.println('9' - 0);
        System.out.println('a' - 0);
        System.out.println('A' - 0);
        System.out.println('P' - 'A');
        System.out.println('P' - 'T');
        System.out.println('J' - '0');
        System.out.println('Q' - '0');
        System.out.println('K' - '0');
        System.out.println('-'-'0');
    }

    public static void main2(String[] args) {
        String a = "1234567890";
        char[] chars = a.toCharArray();
        char[] chars1 = new char[10];
        System.arraycopy(chars,1,chars1,0,10);
        System.out.print(chars1);
    }

    private static char[][] split(char[] src, char c, int n) {
        char[][] results = new char[n][];
        int i, j, k = 0,l;
        for (i = 0, j = 0; i < src.length; i++) {
            if (src[i] == c) {
                l = i - j;
                results[k] = new char[l];
                System.arraycopy(src, j, results[k++], 0, l);
                j = i + 1;
            }
        }
        if (j < src.length) {
            l = src.length - j;
            results[k] = new char[l];
            System.arraycopy(src, j, results[k], 0, l);
        }
        return results;
    }


}
