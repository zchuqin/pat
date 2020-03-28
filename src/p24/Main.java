package p24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;

//1051
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(110000);

    private final static double[] doubles = new double[4];

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        in.close();
        for (int i = 0; i < s.length; i++) { doubles[i] = Double.parseDouble(s[i]);}
        double p = doubles[1] + doubles[3];
        double r = doubles[0] * doubles[2];
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        double a = r * Math.cos(p);
        double b = r * Math.sin(p);
        if (a > -0.01 && a < 0.01) {
            a = 0.00;
        }
        if (b > -0.01 && b < 0.01) {
            b = 0.00;
        }
        sb.append(df.format(a));
        if (b >= 0){ sb.append('+');}
        System.out.println(sb.append(df.format(b)).append('i').toString());
    }
}

