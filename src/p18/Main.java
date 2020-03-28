package p18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//1044
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private static final String[] nums = {"tret", "jan", "feb", "mar", "apr", "may", "jun", "jly", "aug", "sep", "oct", "nov", "dec"};

    private static final String[] nums1 = {"tret", "tam", "hel", "maa", "huh", "tou", "kes", "hei", "elo", "syy", "lok", "mer", "jou"};

    private static final HashMap<String, Integer> map = new HashMap<>(25);

    static {
        map.put("tret", 0);
        map.put("jan", 1);
        map.put("feb", 2);
        map.put("mar", 3);
        map.put("apr", 4);
        map.put("may", 5);
        map.put("jun", 6);
        map.put("jly", 7);
        map.put("aug", 8);
        map.put("sep", 9);
        map.put("oct", 10);
        map.put("nov", 11);
        map.put("dec", 12);
        map.put("tam", 14);
        map.put("hel", 15);
        map.put("maa", 16);
        map.put("huh", 17);
        map.put("tou", 18);
        map.put("kes", 19);
        map.put("hei", 20);
        map.put("elo", 21);
        map.put("syy", 22);
        map.put("lok", 23);
        map.put("mer", 24);
        map.put("jou", 25);
    }

    private static final char[] charsOfNum = new char[4];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        char[] chars;
        int sum;
        StringBuilder sb1 = new StringBuilder();
        while (n-- > 0) {
            chars = in.readLine().toCharArray();
            if (chars[0] >= '0' && chars[0] <= '9') {
                sum = chars[0] - '0';
                sb1.delete(0, sb1.length());
                for (int i = 1; i < chars.length; i++) {
                    sum = sum * 10 + chars[i] - '0';
                }
                if (sum < 13) {
                    sb1.append(nums[sum]);
                } else if (sum % 13 == 0) {
                    sb1.append(nums1[sum / 13]);
                } else{
                    boolean flag = true;
                    while (sum > 0) {
                        if (flag) {
                            sb1.insert(0, nums[sum % 13]);
                            flag = false;
                        } else {
                            sb1.insert(0, ' ').insert(0, nums1[sum % 13]);
                        }
                        sum /= 13;
                    }
                }
                sb.append(sb1).append('\n');
            } else {
                charsOfNum[0] = chars[0];
                int index = 1;
                sum = 0;
                boolean flag;
                for (int i = 1; i < chars.length; i++) {
                    flag = false;
                    if (chars[i] != ' ') {
                        charsOfNum[index++] = chars[i];
                    }
                    if (chars[i] == ' ' || i == chars.length - 1) {
                        Integer integer = map.get(new String(charsOfNum, 0, index));
                        if (integer > 13) {
                            flag = i == chars.length - 1;
                            integer -= 13;
                        }
                        sum = sum * 13 + integer;
                        if (flag) {
                            sum *= 13;
                        }
                        index = 0;
                    }
                }
                sb.append(sum).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}

