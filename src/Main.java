import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node {
    int a;
    int d;
    int n;

    public Node(int a, int d, int n) {
        this.a = a;
        this.d = d;
        this.n = n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = in.readLine().split(" ");
        int start = Integer.parseInt(s1[0]);
        int n = Integer.parseInt(s1[1]);
        int k = Integer.parseInt(s1[2]);
        ArrayList<Node> arrout = new ArrayList<Node>();
        Node arrin[] = new Node[100005];//空间换时间
        while(n--!=0) {
            String s2[] = in.readLine().split(" ");
            int address = Integer.parseInt(s2[0]);
            arrin[address] = new Node(address,Integer.parseInt(s2[1]),Integer.parseInt(s2[2]));
        }
        Node temp = new Node(start,arrin[start].d,arrin[start].n);
        while (true) {
            arrout.add(new Node(temp.a,temp.d,temp.n));
            if (temp.n == -1) break;
            temp.a = arrin[temp.n].a;
            temp.d = arrin[temp.n].d;
            temp.n = arrin[temp.n].n;
        }
        for (int i = 0; i < arrout.size(); i+=k) {
            Outreverse(i,k,arrout);
        }
    }

    private static void Outreverse(int i, int k, ArrayList<Node> arrout) {
        if(i+k<=arrout.size()) {
            for (int p = i+k-1; p >= i; p--) {
                if(p!=i)
                    System.out.printf("%05d %d %05d\n",arrout.get(p).a,arrout.get(p).d,arrout.get(p-1).a);
                else {
                    if(i+2*k<=arrout.size())
                        System.out.printf("%05d %d %05d\n",arrout.get(p).a,arrout.get(p).d,arrout.get(i+2*k-1).a);
                    else {
                        if(i+k>=arrout.size())
                            System.out.printf("%05d %d -1\n",arrout.get(p).a,arrout.get(p).d);
                        else
                            System.out.printf("%05d %d %05d\n",arrout.get(p).a,arrout.get(p).d,arrout.get(i+k).a);
                    }
                }
            }
        }else {
            for (int p = i; p < arrout.size(); p++) {
                if(p==arrout.size()-1)
                    System.out.printf("%05d %d -1\n",arrout.get(p).a,arrout.get(p).d);
                else
                    System.out.printf("%05d %d %05d\n",arrout.get(p).a,arrout.get(p).d,arrout.get(p+1).a);
            }
        }
    }



//    1024
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        char[] s = in.readLine().toCharArray();
//        int e = 3;
//        boolean z = true;
//        boolean f = s[1] == '0';
//        while (e < s.length && s[e] != 'E'){
//            if (s[e++] != '0' && z) {
//                z = false;
//            }
//        }
//        if (z && f){
//            System.out.println('0');
//            return;
//        }
//        int p = 0;
//        for (int i = e + 2; i < s.length; i++) {
//            p = (p * 10) + s[i] - 48;
//        }
//        StringBuilder sb = new StringBuilder();
//        if (s[0] == '-') {
//            sb.append('-');
//        }
//        if (p == 0) {
//            sb.append(s, 1, e - 1);
//        } else if (s[e + 1] == '-') {
//            char[] c = new char[p + 1];
//            for (int i = 0; i < c.length; i++) {
//                c[i] = '0';
//            }
//            c[1] = '.';
//            sb.append(c).append(s[1]).append(s, 3, e - 3);
//        } else if (e - p < 3) {
//            int i = p - e + 3;
//            char[] c = new char[i];
//            for (int i1 = 0; i1 < i; i1++) {
//                c[i1] = '0';
//            }
//            if (f) {
//                int j = 3;
//                while (s[j] == '0') {
//                    j++;
//                }
//                sb.append(s, j, e - j).append(c);
//            } else {
//                sb.append(s[1]).append(s, 3, e - 3).append(c);
//            }
//        } else if (e - p == 3) {
//            sb.append(s[1]).append(s, 3, e - 3);
//        } else {
//            if (f) {
//                char[] c = new char[p];
//                System.arraycopy(s,3,c,0,p);
//                int i = 0;
//                while (c[i++] == '0') {
//                    if (i == p) {
//                        System.out.println(sb.append('0').append('.').append(s, 3 + p, e - p - 3));
//                        return;
//                    }
//                }
//                sb.append(c,i-1,p-i+1).append('.').append(s, 3 + p, e - p - 3);
//            } else {
//                sb.append(s[1]).append(s, 3, p).append('.').append(s, 3 + p, e - p - 3);
//            }
//        }
//        System.out.println(sb);
//    }

//    1023
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = in.readLine().split(" ");
//        boolean flag = false;
//        StringBuilder sb = new StringBuilder();
//        int num;
//        int zNum = Integer.parseInt(s[0]);
//        for (int i = 1; i < 10; i ++) {
//            num = Integer.parseInt(s[i]);
//            char s1 = (char) (i + '0');
//            if (num > 0) {
//                sb.append(s1);
//                if (!flag) {
//                    flag = true;
//                    for (int i1 = 0; i1 < zNum; i1++) {
//                        sb.append('0');
//                    }
//                }
//                while (--num > 0) {
//                    sb.append(s1);
//                }
//            }
//        }
//        System.out.println(sb);
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = in.readLine().split(" ");
//        int a = Integer.parseInt(s[0]);
//        int b = Integer.parseInt(s[1]);
//        int c = Integer.parseInt(s[2]);
//        int d = a + b;
//        StringBuilder sb = new StringBuilder();
//        while (d >= c) {
//            sb.append(d % c);
//            d /= c;
//        }
//        System.out.println(sb.append(d).reverse());
//    }

//    1021
//    private static int[] counts = new int[10];
//    private static int ZERO = '0';
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        char[] chars = in.readLine().toCharArray();
//        for (char c : chars) {
//            counts[c - ZERO]++;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < counts.length; i++) {
//            int c = counts[i];
//            if (c > 0) {
//                sb.append(i).append(':').append(c).append('\n');
//            }
//        }
//        System.out.print(sb);
//    }

// 1020
//class Cake implements Comparable<Cake> {
//    float d;
//    float p;
//    float a;
//
//    Cake(float d, float p, float a) {
//        this.d = d;
//        this.p = p;
//        this.a = a;
//    }
//
//    @Override
//    public int compareTo(Cake o) {
//        return a > o.a ? -1 : 1;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String[] split = in.readLine().split(" ");
//        int n = Integer.parseInt(split[0]);
//        float m = Integer.parseInt(split[1]);
//        String[] split1 = in.readLine().split(" ");
//        String[] split2 = in.readLine().split(" ");
//        Cake[] cs = new Cake[n];
//        for (int i = 0; i < n; i++) {
//            float d = Float.parseFloat(split1[i]);
//            float p = Float.parseFloat(split2[i]);
//            float a = p / d;
//            cs[i] = new Cake(d, p, a);
//        }
//        Arrays.sort(cs);
//        float s = 0f;
//        for (int i = 0; i < cs.length; i++) {
//            if (m >= cs[i].d) {
//                m -= cs[i].d;
//                s += cs[i].p;
//            } else {
//                s += cs[i].a * m;
//                break;
//            }
//        }
//        System.out.println(String.format("%.2f", s));
//    }

//    1017
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder s = new StringBuilder(in.readLine());
//        floa c = Integer.parseInt(s.substring(s.length()-1));
//        long t = 0;
//        s.delete(s.length() - 2, s.length());
//        int a = 0;
//        int b = s.length() % 17;
//        long[] d = new long[s.length()/17+1];
//        int e = 0;
//        boolean flag = true;
//        while (flag) {
//            if (b >= s.length() - 1) {
//                flag = false;
//            }
//            long l = Long.parseLong(t + s.substring(a, b));
//            d[e++] = l / c;
//            t = l % c;
//            a = b;
//            b += 17;
//        }
//        StringBuilder sb = new StringBuilder();
//        boolean flag1 = false;
//        for (long l : d) {
//            if (l != 0 || flag1) {
//                StringBuilder stringBuilder = new StringBuilder(l + "");
//                if (flag1) {
//                    while (stringBuilder.length() < 17) {
//                        stringBuilder.insert(0, "0");
//                    }
//                }
//                sb.append(stringBuilder);
//            }
//            flag1 = true;
//        }
//        sb.append(sb.length() == 0?"0 ":" ").append(t);
//        System.out.println(sb);
//    }

//      1016
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = in.readLine().split("\\s+");
//        int a=0;
//        int b=0;
//        for (char c : s[0].toCharArray()) {
//            if (c == s[1].charAt(0)) {
//                a++;
//            }
//        }
//        for (char c : s[2].toCharArray()) {
//            if (c == s[3].charAt(0)) {
//                b++;
//            }
//        }
//        int c = 0;
//        int da = Integer.parseInt(s[1]);
//        int db = Integer.parseInt(s[3]);
//        if (a > b) {
//            for (int i = 0; i < a-b; i++) {
//                c = da + c * 10;
//            }
//            for (int i = a-b; i < a; i++) {
//                c = (da + db) + c * 10;
//            }
//        } else if (a == b) {
//            for (int i = 0; i < b; i++) {
//                c = (da + db) + c * 10;
//            }
//        } else {
//            for (int i = 0; i < b-a; i++) {
//                c = db + c * 10;
//            }
//            for (int i = b-a; i < b; i++) {
//                c = (da + db) + c * 10;
//            }
//        }
//        System.out.println(c);
//    }

//    1015
//        public static void main(String[] args) throws IOException {
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	//快了50-100ms
//            String s1[] = in.readLine().split("\\s+");
//            int n = Integer.valueOf(s1[0]);
//            int l = Integer.valueOf(s1[1]);
//            int h = Integer.valueOf(s1[2]);
//            ArrayList<Node> arr1 = new ArrayList<Node>();
//            ArrayList<Node> arr2 = new ArrayList<Node>();
//            ArrayList<Node> arr3 = new ArrayList<Node>();
//            ArrayList<Node> arr4 = new ArrayList<Node>();
//            int ans = 0;
//            while(n-- !=0) {
//                String s2[] = in.readLine().split("\\s+");
//                int a = Integer.valueOf(s2[0]);
//                int b = Integer.valueOf(s2[1]);
//                int c = Integer.valueOf(s2[2]);
//                if(b>=l && c>=l) {
//                    ans++;
//                    if(b>=h && c>=h) {
//                        arr1.add(new Node(a,b,c));
//                    }else if(b>=h && c<h) {
//                        arr2.add(new Node(a,b,c));
//                    }else if(b<h && c<h && b>=c) {
//                        arr3.add(new Node(a,b,c));
//                    }else {
//                        arr4.add(new Node(a,b,c));
//                    }
//                }
//            }
//            Collections.sort(arr1);
//            Collections.sort(arr2);
//            Collections.sort(arr3);
//            Collections.sort(arr4);
//            System.out.println(ans);
//            for (int i = 0; i < arr1.size(); i++) {
//                System.out.println(arr1.get(i).a+" "+arr1.get(i).b+" "+arr1.get(i).c);
//            }
//            for (int i = 0; i < arr2.size(); i++) {
//                System.out.println(arr2.get(i).a+" "+arr2.get(i).b+" "+arr2.get(i).c);
//            }
//            for (int i = 0; i < arr3.size(); i++) {
//                System.out.println(arr3.get(i).a+" "+arr3.get(i).b+" "+arr3.get(i).c);
//            }
//            for (int i = 0; i < arr4.size(); i++) {
//                System.out.println(arr4.get(i).a+" "+arr4.get(i).b+" "+arr4.get(i).c);
//            }
//        }
//
//    private static class Node implements Comparable<Node>{
//        int a,b,c;
//        int sum;
//        Node(int a,int b,int c){
//            this.a=a;
//            this.b=b;
//            this.c=c;
//            sum = b+c;
//        }
//        @Override
//        public int compareTo(Node o) {
//            if(o.sum-this.sum!=0)
//                return o.sum-this.sum;
//            else if(o.b-this.b!=0)
//                return o.b-this.b;
//            else
//                return this.a-o.a;
//        }
//    }


//    1014
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        char[] s1 = scanner.nextLine().toCharArray();
//        char[] s2 = scanner.nextLine().toCharArray();
//        char[] s3 = scanner.nextLine().toCharArray();
//        char[] s4 = scanner.nextLine().toCharArray();
//        int len1 = s1.length < s2.length ? s1.length : s2.length;
//        int len2 = s3.length < s4.length ? s3.length : s4.length;
//        String[] arr1 = new String[]{"MON","TUE","WED","THU","FRI","SAT","SUN"};
//        boolean flag = false;
//        char c1 = 0;
//        char c2 = 0;
//        int c3=-1;
//        for (int i = 0; i < len1; i++) {
//            if (s1[i] == s2[i]) {
//                if (flag) {
//                    if ('A' <= s1[i] && 'N' >= s1[i]) {
//                        c2 = s1[i];
//                        break;
//                    } else if ('0' <= s1[i] && '9' >= s1[i]) {
//                        c2 = s1[i];
//                        break;
//                    }
//                } else if ('A' <= s1[i] && 'G' >= s1[i]) {
//                    c1 = s1[i];
//                    flag = true;
//                }
//            }
//        }
//        for (int i = 0; i < len2; i++) {
//            c3++;
//            if (s3[i] == s4[i] && ((s3[i]>64 && s3[i]<91)||(s3[i]>96 && s3[i]<123))) {
//                break;
//            }
//        }
//        StringBuilder stringBuilder = new StringBuilder().append(arr1[c1 - 'A']).append(" ").append(c2 - 'A' < 0 ? ("0"+(c2 - '0')) : (c2 - 'A' + 10)).append(":").append(c3 < 10 ? "0" : "").append(c3);
//        System.out.println(stringBuilder);
//    }


//    1013
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int times = 0;
//        LinkedList<Integer> integers = new LinkedList<>();
//        integers.add(2);
//        if (n == 1) {
//            times++;
//            System.out.print("2");
//        }
//        int count = 2;
//        int num = 3;
//        while (count <= m) {
//            boolean flag = true;
//            Iterator<Integer> iterator = integers.iterator();
//            for (int i = 3; i * i <= num && iterator.hasNext(); i = iterator.next()) {
//                if (num % i == 0) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                if (count >= n) {
//                    System.out.print((times++ % 10 == 0 ? (count > n ? "\n" : "") : " ") + num);
//                }
//                integers.add(num);
//                count++;
//            }
//            num+=2;
//        }
//    }

//    1012
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] results = new int[7];
//        boolean[] flags = new boolean[5];
//        for (int i = 0; i < n; i++) {
//            int number = scanner.nextInt();
//            switch (number % 5) {
//                case 4:
//                    flags[4] = true;
//                    if (results[0] < number) {
//                        results[0] = number;
//                    }
//                    break;
//                case 3:
//                    flags[3] = true;
//                    results[1] += number;
//                    results[2] ++;
//                    break;
//                case 2:
//                    flags[2] = true;
//                    results[3] ++;
//                    break;
//                case 1:
//                    flags[1] = true;
//                    results[4] ++;
//                    results[5] += number * (results[4] % 2 == 0 ? -1 : 1);
//                    break;
//                case 0:
//                    if (number%2==0){
//                        flags[0] = true;
//                        results[6] += number;
//                    }
//                    break;
//            }
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(flags[0] ? results[6] : "N").append(" ")
//                .append(flags[1] ? results[5] : "N").append(" ")
//                .append(flags[2] ? results[3] : "N").append(" ")
//                .append(flags[3] ? new BigDecimal((results[1] + 0.0) / results[2]).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue() : "N").append(" ")
//                .append(flags[4] ? results[0] : "N");
//        System.out.println(stringBuilder);
//    }

//    1011
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        if (n > 0) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < n; i++) {
//                Long a = scanner.nextLong();
//                Long b = scanner.nextLong();
//                Long c = scanner.nextLong();
//                stringBuilder.append("\nCase #"+(i+1)+": "+(a+b > c));
//            }
//            System.out.println(stringBuilder.deleteCharAt(0));
//        }
//    }

//    1010
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        while (scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            if (m * n != 0) {
//                sb.append(" ").append(n * m).append(" ").append(m - 1);
//            }
//        }
//        if (sb.length() > 1){
//            System.out.println( sb.deleteCharAt(0));
//        } else {
//            System.out.println("0 0");
//        }
//    }

//    1009
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//
////        String[] s1 = s.split(" ");
////        StringBuilder stringBuilder = new StringBuilder();
////        for (int i = s1.length - 1; i >= 0; i--) {
////            stringBuilder.append(" ").append(s1[i]);
////        }
////        System.out.println(stringBuilder.deleteCharAt(0));
//
//        LinkedList<Integer> integers = new LinkedList<>();
//        integers.add(-1);
//        int i = 0;
//        char[] chars = s.toCharArray();
//        for (char c : chars) {
//            if (c == ' ') {
//                integers.add(i);
//            }
//            i++;
//        }
//        integers.add(chars.length);
//        StringBuilder stringBuilder = new StringBuilder();
//        Integer start = integers.pollLast();
//        Integer end = start;
//        while ((start = integers.pollLast()) != null) {
//            for (int integer = start + 1; integer < end; integer++) {
//                stringBuilder.append(chars[integer]);
//            }
//            stringBuilder.append(' ');
//            end = start;
//        }
//        System.out.println(stringBuilder.deleteCharAt(stringBuilder.length()-1));
//    }

//    1008
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        m %= n;
//        int[] ints = new int[n];
//        for (int i = 0; i < ints.length; i++) {
//            ints[i] = scanner.nextInt();
//        }
//        StringBuilder sb = new StringBuilder();
//        if (m==0) {
//            for (int anInt : ints) {
//                sb.append(" ").append(anInt);
//            }
//        } else {
//            for (int i = n - m; i < ints.length; i++) {
//                sb.append(" ").append(ints[i]);
//            }
//            for (int i = 0; i < n - m; i++) {
//                sb.append(" ").append(ints[i]);
//            }
//        }
//        sb.deleteCharAt(0);
//        System.out.println(sb);
//    }

//    1007 素数对猜想
//    2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        long l = System.currentTimeMillis();
//        if (n < 5) {
//            System.out.println(0);
//        } else {
//            int t = 0;
//            LinkedList<Integer> integers = new LinkedList<>();
//            integers.add(2);
//            integers.add(3);
//            for (int i = 5; i <= n; i += 2) {
//                boolean flag = true;
//                Iterator<Integer> iterator = integers.iterator();
//                int j = iterator.next();
//                while (iterator.hasNext() && j*j < i) {
//                    j = iterator.next();
//                    if (i % j == 0) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    if (i - integers.getLast() == 2) {
//                        t++;
//                    }
//                    integers.add(i);
//                }
//            }
//            System.out.println(t);
//        }
//        System.out.println(System.currentTimeMillis() - l);
//    }

//    1006
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] ints = new int[3];
//        ints[2] = n % 10;
//        ints[1] = (n/10) % 10;
//        ints[0] = (n/100) % 10;
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < ints[0]; i++) {
//            stringBuilder.append("B");
//        }
//        for (int i = 0; i < ints[1]; i++) {
//            stringBuilder.append("S");
//        }
//        for (int i = 0; i < ints[2]; i++) {
//            stringBuilder.append(i+1);
//        }
//        System.out.println(stringBuilder);
//    }
//    1005
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        LinkedList<Integer> ints = new LinkedList<>();
//        int[] ints1 = new int[n];
//        for (int i = 0; i < n; i++) {
//            ints1[i] = (scanner.nextInt());
//        }
//        for (Integer number : ints1) {
//            while (number != 1) {
//                if (number % 2 == 0) {
//                    number >>= 1;
//                } else {
//                    number = (number * 3 + 1) >> 1;
//                }
//                int i = Collections.binarySearch(ints, number);
//                if (i < 0) {
//                    ints.add(-1-i,number);
//                } else {
//                    break;
//                }
//            }
//        }
//        int z = 0;
//        for (Integer number : ints1) {
//            int j = Collections.binarySearch(ints, number);
//            if (j < 0) {
//                z++;
//                for (int i1 = 0; i1 < z; i1++) {
//                    if (ints.get(i1) < number || i1 == z - 1){
//                        ints.add(i1,number);
//                        break;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < z; i++) {
//            System.out.print((i != 0 ? " " : "") + ints.get(i));
//        }
//    }
//    1004
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        String[] arr = new String[6];
//        int tmp,max = -1, min = -1;
//        for (int i = 0; i < n; i++) {
//            arr[0] = scanner.next();
//            arr[1] = scanner.next();
//            tmp = scanner.nextInt();
//            if (i == 0) {
//                max = tmp;
//                arr[2] = arr[0];
//                arr[3] = arr[1];
//                min = tmp;
//                arr[4] = arr[0];
//                arr[5] = arr[1];
//            }
//            if (tmp > max) {
//                max = tmp;
//                arr[2] = arr[0];
//                arr[3] = arr[1];
//            }
//            if (tmp < min) {
//                min = tmp;
//                arr[4] = arr[0];
//                arr[5] = arr[1];
//            }
//        }
//        System.out.println(arr[2]+" "+arr[3]);
//        System.out.println(arr[4]+" "+arr[5]);
//    }

    //1003
    // 如果 aPbTc 是正确的，那么 aPbATca 也是正确的
    // AAPAATAAAA  AA P A AT AA AA   AAPATAA
    // APATA   APAATAAA
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            StringBuilder str = new StringBuilder(scanner.next());
//            int p = str.indexOf("P");
//            if (p < 0){
//                System.out.println("NO");
//                continue;
//            }
//            int t = str.indexOf("T");
//            if (t < 0){
//                System.out.println("NO");
//                continue;
//            }
//            int midLen = t - p - 1;
//            boolean flag = false;
//            if (midLen > 0 && str.length() - t - 1 == p * midLen) {
//                str.deleteCharAt(p).deleteCharAt(t-1);
//                for (int i1 = 0; i1 < str.length(); i1++) {
//                    if ('A' != str.charAt(i1)) {
//                        flag = true;
//                    }
//                }
//                System.out.println(flag?"NO":"YES");
//                continue;
//            }
//            System.out.println("NO");
//        }
//        scanner.close();
//    }

//    1002 写出这个数
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        String number = "";
//        number = input.nextLine();
//
//        int n = 0;
//        for (int i = 0; i < number.length(); i++) {
//            n += Integer.parseInt(number.charAt(i)+"");
//        }
//
//        int[] member = new int[3];
//        String[] pronounce = new String[]{"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
//
//        int k = 0;
//        while (n >= 10) {
//            member[k] = n % 10;
//            n /= 10;
//            k ++;
//        }
//        member[k] = n % 10;
//
//        for (int j = k; j >= 0; j--) {
//            System.out.print(pronounce[member[j]] + ((j == 0) ? "" : " "));
//        }
//    }

//    1001  害死人不偿命的3n+1
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        int number;
//        do {
//            number = input.nextInt();
//        } while (number > 1000 || number <= 0);
//
//        int n = 0;
//        while (number != 1) {
//            n += 1;
//            if (number % 2 == 0) {
//                number /= 2;
//            } else {
//                number = (number * 3 + 1) / 2;
//            }
//        }
//        System.out.println(n);
//    }
}

