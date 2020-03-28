package p12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1038
public class Main {
    private  static final char[][] scores = {
            {'0'},{'1'},{'2'},{'3'},{'4'},{'5'},{'6'},{'7'},{'8'},{'9'},
            {'1','0'},{'1','1'},{'1','2'},{'1','3'},{'1','4'},{'1','5'},{'1','6'},{'1','7'},{'1','8'},{'1','9'},
            {'2','0'},{'2','1'},{'2','2'},{'2','3'},{'2','4'},{'2','5'},{'2','6'},{'2','7'},{'2','8'},{'2','9'},
            {'3','0'},{'3','1'},{'3','2'},{'3','3'},{'3','4'},{'3','5'},{'3','6'},{'3','7'},{'3','8'},{'3','9'},
            {'4','0'},{'4','1'},{'4','2'},{'4','3'},{'4','4'},{'4','5'},{'4','6'},{'4','7'},{'4','8'},{'4','9'},
            {'5','0'},{'5','1'},{'5','2'},{'5','3'},{'5','4'},{'5','5'},{'5','6'},{'5','7'},{'5','8'},{'5','9'},
            {'6','0'},{'6','1'},{'6','2'},{'6','3'},{'6','4'},{'6','5'},{'6','6'},{'6','7'},{'6','8'},{'6','9'},
            {'7','0'},{'7','1'},{'7','2'},{'7','3'},{'7','4'},{'7','5'},{'7','6'},{'7','7'},{'7','8'},{'7','9'},
            {'8','0'},{'8','1'},{'8','2'},{'8','3'},{'8','4'},{'8','5'},{'8','6'},{'8','7'},{'8','8'},{'8','9'},
            {'9','0'},{'9','1'},{'9','2'},{'9','3'},{'9','4'},{'9','5'},{'9','6'},{'9','7'},{'9','8'},{'9','9'},
            {'1','0','0'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String  nStr = in.readLine();
        String[] split = in.readLine().split(" ");
        String[] scores = in.readLine().split(" ");
        in.close();
        int n = Integer.parseInt(nStr);
        int k = Integer.parseInt(scores[0]);
        int[] counts = new int[101];
        for (int i = 0; i < n; i++) {
            counts[Integer.parseInt(split[i])]++;
        }
        StringBuilder sb = new StringBuilder(210000);
        for (int i = 1; i < k + 1; i++) {
            int i1 = Integer.parseInt(scores[i]);
            sb.append((i1 >= 0 && i1 <= 100) ? counts[i1] : '0').append(' ');
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
