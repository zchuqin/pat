package p36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//1068
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split("[\\s|\\t]+");
        int m = parseInt(s[0].toCharArray());
        int n = parseInt(s[1].toCharArray());
        int TOL = parseInt(s[2].toCharArray());
        int NTOL = -TOL;
        if (m == 1) {
            int[] ints = new int[n];
            boolean[] booleans = new boolean[n];
            HashMap<Integer, Boolean> booleanHashMap = new HashMap<>();
            ints[0] = parseInt(in.readLine().toCharArray());
            booleanHashMap.put(ints[0],Boolean.TRUE);
            for (int i = 1; i < n; i++) {
                ints[i] = parseInt(in.readLine().toCharArray());
                booleanHashMap.compute(ints[i],(k,v)-> v == null);
                int i1 = ints[i] + TOL;
                int i2 = ints[i] - TOL;
                boolean b = ints[i - 1] >= i2 && ints[i - 1] <= i1;
                booleans[i - 1] |= b;
                booleans[i] |= b;
            }
            int resultY = -1;
            Boolean flag;
            for (int i = 0; i < n; i++) {
                if (!booleans[i] && (flag = booleanHashMap.get(ints[i])) != null && flag) {
                    if (resultY >= 0) {
                        System.out.println("Not Unique");
                        return;
                    }
                    resultY = i;
                }
            }
            if (resultY >= 0) {
                System.out.println("(1, " + (resultY + 1) + "): " + ints[resultY]);
            } else {
                System.out.println("Not Exist");
            }
        } else {
            int[][] intss = new int[n][m];
            boolean[][] booleanss = new boolean[n][m];
            HashMap<Integer, Boolean> booleanHashMap = new HashMap<>();

            String[] split = in.readLine().split("[\\s|\\t]+");
            intss[0][0] = parseInt(split[0].toCharArray());
            booleanHashMap.put(intss[0][0],Boolean.TRUE);
            for (int i1 = 1; i1 < m; i1++) {
                intss[0][i1] = parseInt(split[i1].toCharArray());
                booleanHashMap.compute(intss[0][i1],(k,v)-> v == null);
                int sub = intss[0][i1] - intss[0][i1 - 1];
                boolean b = sub <= TOL && sub >= NTOL;
                booleanss[0][i1] |= b;
                booleanss[0][i1 - 1] |= b;
            }

            for (int i = 1; i < n; i++) {
                split = in.readLine().split("[\\s|\\t]+");
                intss[i][0] = parseInt(split[0].toCharArray());
                booleanHashMap.compute(intss[i][0],(k,v)-> v == null);

                int i2 = intss[i][0] - TOL;
                int i3 = intss[i][0] + TOL;
                boolean b = intss[i - 1][0] >= i2 && intss[i - 1][0] <= i3;
                booleanss[i - 1][0] |= b;
                booleanss[i][0] |= b;
                boolean b2 = intss[i - 1][1] >= i2 && intss[i - 1][1] <= i3;
                booleanss[i - 1][1] |= b2;
                booleanss[i][0] |= b2;

                for (int i1 = 1; i1 < m; i1++) {
                    intss[i][i1] = parseInt(split[i1].toCharArray());
                    booleanHashMap.compute(intss[i][i1],(k,v)-> v == null);

                    int i4 = intss[i][i1] - TOL;
                    int i5 = intss[i][i1] + TOL;
                    boolean b3 = intss[i - 1][i1] >= i4 && intss[i - 1][i1] <= i5;
                    booleanss[i - 1][i1] |= b3;
                    booleanss[i][i1] |= b3;
                    boolean b4 = intss[i - 1][i1 - 1] >= i4 && intss[i - 1][i1 - 1] <= i5;
                    booleanss[i - 1][i1 - 1] |= b4;
                    booleanss[i][i1] |= b4;
                    if (i1 + 1 < m) {
                        boolean b5 = intss[i - 1][i1 + 1] >= i4 && intss[i - 1][i1 + 1] <= i5;
                        booleanss[i - 1][i1 + 1] |= b5;
                        booleanss[i][i1] |= b5;
                    }
                    boolean b6 = intss[i][i1 - 1] >= i4 && intss[i][i1 - 1] <= i5;
                    booleanss[i][i1 - 1] |= b6;
                    booleanss[i][i1] |= b6;
                }
            }
            int resultX = -1;
            int resultY = -1;
            Boolean flag;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!booleanss[i][j] && (flag = booleanHashMap.get(intss[i][j])) != null && flag) {
                        if (resultY >= 0) {
                            System.out.println("Not Unique");
                            return;
                        }
                        resultX = j;
                        resultY = i;
                    }
                }
            }
            if (resultY >= 0) {
                System.out.println("(" + (resultX + 1) + ", " + (resultY + 1) + "): " + intss[resultY][resultX]);
            } else {
                System.out.println("Not Exist");
            }
        }

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



