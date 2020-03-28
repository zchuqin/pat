package p28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

//1053
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(100000);

    private final static DecimalFormat df = new DecimalFormat("#.##");

    static {
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        in.close();
        int k = 0;
        double sum = 0.0;

        // ^[-]?(\d{0,3}|1000)$|^[-]?\d{0,3}\.[0-9]{0,2}$|^[-]?1000\.0{0,2}$
        for (String str : s) {
            int i = str.indexOf('.');
            if (i >= 0 && i < str.length() - 3) {
                sb.append("ERROR: ").append(str).append(" is not a legal number\n");
            } else {
                try {
                    double v = Double.parseDouble(str);
                    if (v < -1000.0 || v > 1000.0) {
                        sb.append("ERROR: ").append(str).append(" is not a legal number\n");
                    } else {
                        k++;
                        sum += v;
                    }
                } catch (Exception e) {
                    sb.append("ERROR: ").append(str).append(" is not a legal number\n");
                }
            }
        }
        if (k == 0) {
            sb.append("The average of 0 numbers is Undefined");
        } else if (k == 1) {
            sb.append("The average of 1 number is ").append(df.format(sum));
        } else {
            sb.append("The average of ").append(k).append(" numbers is ").append(df.format(sum / k));
        }
        System.out.print(sb.toString());
    }
}



