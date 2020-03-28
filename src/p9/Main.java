package p9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1034
public class Main {

    private static final String INSERTION_SORT = "Insertion Sort\n";
    private static final String MERGE_SORT = "Merge Sort\n";
    private static final int[] arr = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] ns = new int[n];
        int[] ns1 = new int[n];
        String str = in.readLine();
        String[] s1 = in.readLine().split(" ");
        in.close();
        String[] s = str.split(" ");
        ns[0] = Integer.parseInt(s[0]);
        ns1[0] = Integer.parseInt(s1[0]);
        boolean flag = false;
        boolean flag1 = true;
        int b = 0;
        for (int i = 1; i < s.length; i++) {
            ns[i] = Integer.parseInt(s[i]);
            ns1[i] = Integer.parseInt(s1[i]);
            if (!flag1) continue;
            if (flag) {
                flag1 = ns1[i] == ns[i];
            } else {
                if (ns1[i - 1] > ns1[i]) {
                    flag = true;
                    b = i;
                    flag1 = ns1[i] == ns[i];
                }
            }
        }
        StringBuilder sb = new StringBuilder(str.length()+20);
        if (flag1) {
            sb.append(INSERTION_SORT);
            insertionSort(ns1, b);
        } else {
            sb.append(MERGE_SORT);
            mergeSort(ns1,mergeOrder(ns1));
        }
        System.out.print(append(sb, ns1).toString());
    }

    private static int mergeOrder(int[] ns1) {
        int a = 0;
        int b = 1;
        for (int i = 1; i < ns1.length; i++) {
            if (ns1[i - 1] > ns1[i]) {
                arr[a] = b;
                a++;
                b = 1;
            } else {
                b++;
            }
        }
        int k = 1;
        boolean flag = true;
        while (true) {
            if (flag) {
                for (int i = 0; i < a; i++) {
                    if (arr[i] % k != 0) {
                        flag = false;
                    }
                }
                k <<= 1;
            } else {
                k >>= 2;
                break;
            }
        }
        return k;
    }


    private static void insertionSort(int[] ns,int i) {
        for (int i1 = 0; i1 < i; i1++) {
            if (ns[i] < ns[i1]) {
                int tmp = ns[i];
                System.arraycopy(ns, i1, ns, i1 + 1, i - i1);
                ns[i1] = tmp;
                break;
            }
        }
    }

    private static void mergeSort(int[] ns, int k) {
        int i, j;
        for (j = 0, i = k << 1; i < ns.length; j = i, i += k << 1) {
            Arrays.sort(ns, j, i);
        }
        if (ns.length - j > k) {
            Arrays.sort(ns, j, ns.length);
        }
    }

    private static StringBuilder append(StringBuilder sb, int[] ns) {
        for (int n : ns) sb.append(n).append(' ');
        return sb.deleteCharAt(sb.length() - 1);
    }

}
