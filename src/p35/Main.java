package p35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1067
public class Main {
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        String pass = s[0];
        int n = Integer.parseInt(s[1]);
        int count = 0;
        while (true) {
            String input = in.readLine();
            if (input.equals("#")) {
                break;
            } else if (pass.equals(input)) {
                System.out.println("Welcome in");
                break;
            } else {
                System.out.print("Wrong password: ");
                System.out.println(input);
                if (++count >= n) {
                    System.out.println("Account locked");
                    break;
                }
            }
        }
    }
}



