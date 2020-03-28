package p17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1043
public class Main {
    private static final char[] Ps = new char[10001];
    private static final char[] As = new char[10001];
    private static final char[] Ts = new char[10001];
    private static final char[] es = new char[10001];
    private static final char[] ss = new char[10001];
    private static final char[] ts = new char[10001];
    private static int[] nums = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = in.readLine().toCharArray();
        in.close();
        for (char c : chars) {
            switch (c) {
                case 'P':
                    nums[0]++;
                    break;
                case 'A':
                    nums[1]++;
                    break;
                case 'T':
                    nums[2]++;
                    break;
                case 'e':
                    nums[3]++;
                    break;
                case 's':
                    nums[4]++;
                    break;
                case 't':
                    nums[5]++;
                    break;
                default:
            }
        }
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        Arrays.fill(Ps, 0, nums[0] , 'P');
        Arrays.fill(As, 0, nums[1] , 'A');
        Arrays.fill(Ts, 0, nums[2] , 'T');
        Arrays.fill(es, 0, nums[3] , 'e');
        Arrays.fill(ss, 0, nums[4] , 's');
        Arrays.fill(ts, 0, nums[5] , 't');
        char[] chars1 = new char[6 * max];
        for (int i = 0; i < max; i++) {
            chars1[i * 6] = Ps[i];
            chars1[i * 6 + 1] = As[i];
            chars1[i * 6 + 2] = Ts[i];
            chars1[i * 6 + 3] = es[i];
            chars1[i * 6 + 4] = ss[i];
            chars1[i * 6 + 5] = ts[i];
        }
        StringBuilder sb = new StringBuilder(sum);
        for (char c : chars1) {
            if (c != 0) {
                sb.append(c);
            }
        }
        System.out.print(sb.toString());
    }
}
