package p29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//1053
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private final static StringBuilder sb = new StringBuilder(100000);

    private final static ArrayList<Person> list = new ArrayList<>(10000);

    public static void main(String[] args) throws IOException {
        String[] s = split(in.readLine());
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        for (int i = 0; i < N; i++) {
            String[] s1 = split(in.readLine());
            list.add(new Person(s1[0], Integer.parseInt(s1[1])));
        }
        Collections.sort(list);
        int m = N / K;
        int offset = m * (K - 1);
        int end = N;
        int o = (end - offset) % 2;
        append(offset, end, o);
        end = offset;
        offset -= m;
        o = m % 2;
        while (offset >= 0) {
            append(offset, end, o);
            end = offset;
            offset -= m;
        }
        System.out.print(sb.toString());
    }

    private static void append(int offset, int end, int o) {
        int index = offset + o;
        if (index >= end) {
            //当一行只有一人时
            sb.append(Main.list.get(index - 1).name).append('\n');
            return;
        }
        int count = offset;
        boolean flag = true;
        while (count < end) {
            sb.append(Main.list.get(index).name).append(' ');
            count++;
            if (flag) {
                if (index < end) {
                    index += 2;
                }
                if (index >= end) {
                    index--;
                    flag = false;
                }
            } else {
                index -= 2;
            }
        }
        sb.setCharAt(sb.length() - 1, '\n');
    }

    private static String[] split(String readLine) {
        char[] chars = readLine.toCharArray();
        String[] strings = new String[2];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                strings[0] = readLine.substring(0, i);
                strings[1] = readLine.substring(i + 1);
                return strings;
            }
        }
        return strings;
    }
}

class Person implements Comparable<Person>{

    String name;

    int height;

    Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(Person person) {
        if (height != person.height) {
            return height - person.height;
        } else {
            return person.name.compareTo(name);
        }
    }

}



