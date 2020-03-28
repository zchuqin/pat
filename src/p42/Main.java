package p42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//1075
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(100000);

    private static final Node[] nodes = new Node[100000];

    private static final List<Node> list1 = new ArrayList<>(50000);

    private static final List<Node> list2 = new ArrayList<>(50000);

    private static final List<Node> list3 = new ArrayList<>(50000);

    public static void main(String[] args) throws IOException {
        int[] s = split(in.readLine().toCharArray(), ' ', 3);
        int n = s[1];
        int k = s[2];
        for (int i = 0; i < n; i++) {
            int[] s1 = split(in.readLine().toCharArray(), ' ', 3);
            nodes[s1[0]] = new Node(s1[0],s1[1], s1[2]);
        }
        int index = s[0];
        while (index != -1) {
            Node node = nodes[index];
            int data = node.data;
            if (data < 0) {
                list1.add(node);
            } else if (data <= k) {
                list2.add(node);
            } else {
                list3.add(node);
            }
            index = node.next;
        }
        boolean flag = true;
        for (Node node : list1) {
            flag = append(toCharArray(node.address,5),node.data, flag);
        }
        for (Node node : list2) {
            flag = append(toCharArray(node.address,5),node.data, flag);
        }
        for (Node node : list3) {
            flag = append(toCharArray(node.address,5),node.data, flag);
        }
        System.out.println(sb.append("-1").toString());
    }

    private static boolean append(char[] chars1,int data, boolean flag) {
        if (flag) {
            sb.append(chars1).append(' ').append(data).append(' ');
        } else {
            sb.append(chars1).append('\n').append(chars1).append(' ').append(data).append(' ');
        }
        return false;
    }

    private static int[] split(char[] src, char c, int n) {
        int[] results = new int[n];
        int i, j, k = 0, l;
        char[] r;
        for (i = 0, j = 0; i < src.length; i++) {
            if (src[i] == c) {
                if (src[j] == '-') {
                    l = i - j - 1;
                    r = new char[l];
                    System.arraycopy(src, j + 1, r, 0, l);
                    results[k++] = - parseInt(r);
                } else {
                    l = i - j;
                    r = new char[l];
                    System.arraycopy(src, j, r, 0, l);
                    results[k++] = parseInt(r);
                }
                j = i + 1;
            }
        }
        if (j < src.length) {
            if (src[j] == '-') {
                l = src.length - j - 1;
                r = new char[l];
                System.arraycopy(src, j + 1, r, 0, l);
                results[k] = - parseInt(r);
            } else {
                l = src.length - j;
                r = new char[l];
                System.arraycopy(src, j, r, 0, l);
                results[k] = parseInt(r);
            }
        }
        return results;
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

    private static char[] toCharArray(int n,int length) {
        char[] chars = new char[length];
        int i = length - 1;
        while (i >= 0) {
            chars[i] = (char) ((n % 10) + 48);
            n = n / 10;
            i--;
        }
        return chars;
    }

    private static class Node {
        int address;
        int data;
        int next;

        Node(int address, int data, int next) {
            this.address = address;
            this.data = data;
            this.next = next;
        }
    }

}



