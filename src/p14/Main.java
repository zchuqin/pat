package p14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1040
public class Main {
    private static int numberOfP;
    private static int numberOfA;
    private static int numberOfT;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = in.readLine().toCharArray();
        long[] numbersOfP = new long[chars.length];
        long[] numbersOfT = new long[chars.length];
        for (char aChar : chars) {
            switch (aChar - 'P') {
                case -15:
                    numbersOfP[numberOfA] = numberOfP;
                    numbersOfT[numberOfA] = numberOfT;
                    numberOfA++;
                    break;
                case 4:
                    numberOfT++;
                    break;
                case 0:
                    numberOfP++;
                    break;
                default:
            }
        }
        long result = 0;
        for (int i = 0; i < numberOfA; i++) {
            result += numbersOfP[i] * (numberOfT - numbersOfT[i]) % 1000000007;
        }
        System.out.print(result % 1000000007);
    }
}
