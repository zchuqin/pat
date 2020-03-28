package p8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1033
public class Main {
    private static long a1;
    private static long b1;
    private static long a2;
    private static long b2;
    private static long a31;
    private static long a32;
    private static long a33;
    private static long b3;
    private static boolean negative1;
    private static boolean negative2;
    private static boolean zero1;
    private static boolean zero2;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split("[/\\s]");
        in.close();
        StringBuilder sb = new StringBuilder();
        a1 = Long.parseLong(s[0]);
        if (a1 == 0) {
            zero1 = true;
        } else {
            negative1 = a1 < 0;
            if (negative1) a1 = -a1;
            b1 = Long.parseLong(s[1]);
            long gd1 = getGD(a1, b1);
            a1 /= gd1;
            b1 /= gd1;
        }
        a2 = Long.parseLong(s[2]);
        if (a2 == 0) {
            zero2 = true;
        } else {
            negative2 = a2 < 0;
            if (negative2) a2 = -a2;
            b2 = Long.parseLong(s[3]);
            long gd2 = getGD(a2, b2);
            a2 /= gd2;
            b2 /= gd2;
        }
        if (zero1) {
            if (zero2) {
                System.out.println("0 + 0 = 0\n0 - 0 = 0\n0 * 0 = 0\n0 / 0 = Inf\n");
                return;
            } else {
                append(sb.append("0 + "),negative2, a2, b2);
                append(sb.append(" = "),negative2, a2, b2);
                append(sb.append("\n0 - "),negative2, a2, b2);
                append(sb.append("= "),!negative2, a2, b2);
                append(sb.append("\n0 * "),negative2, a2, b2);
                sb.append(" = 0");
                append(sb.append("\n0 / "),negative2, a2, b2);
                sb.append(" = 0");
            }
        } else {
            if (zero2) {
                StringBuilder sb1 = new StringBuilder();
                append(sb1,negative1, a1, b1);
                sb.append(sb1).append(" + 0 = ").append(sb1)
                        .append('\n').append(sb1).append(" - 0 = ").append(sb1)
                        .append('\n').append(sb1).append(" * 0 = 0")
                        .append('\n').append(sb1).append(" / 0 = Inf");
            } else {
                StringBuilder sb1 = append(new StringBuilder(), negative1, a1, b1);
                StringBuilder sb2 = append(new StringBuilder(), negative2, a2, b2);
                if (negative1) {
                    a1 = -a1;
                }
                if (negative2) {
                    a2 = -a2;
                }
                b3 = b1 * b2;
                a31 = a1 * b2;
                a32 = a2 * b1;
                a33 = a1 * a2;
                sb.append(sb1).append(" + ").append(sb2).append(" = ");
                append(sb, a31 + a32,b3);
                sb.append('\n').append(sb1).append(" - ").append(sb2).append(" = ");
                append(sb, a31 - a32,b3);
                sb.append('\n').append(sb1).append(" * ").append(sb2).append(" = ");
                append(sb, a33,b3);
                sb.append('\n').append(sb1).append(" / ").append(sb2).append(" = ");
                append(sb, a31,a32);
            }
        }
        System.out.println(sb.toString());
    }


    //辗转相除法
    private static long getGD(long n, long m) {
        return m == 0 ? n : getGD(m , n % m);
    }

    private static StringBuilder append(StringBuilder sb, boolean negative, long a, long b) {
        if (negative) {
            sb.append("(-");
        }
        if (b == 1) {
            sb.append(a);
        } else{
            if (a / b != 0) {
                sb.append(a / b).append(' ');
            }
            sb.append(a % b).append('/').append(b);
        }
        if (negative) {
            sb.append(')');
        }
        return sb;
    }

    private static StringBuilder append(StringBuilder sb, long a, long b) {
        if (a == 0) {
            return sb.append('0');
        }
        boolean negative = false;
        if (a < 0) {
            negative = !negative;
            a = -a;
        }
        if (b < 0) {
            negative = !negative;
            b = -b;
        }
        long gd = getGD(a, b);
        a /= gd;
        b /= gd;
        return append(sb, negative, a, b);
    }
}
