package soup.algorithms.boj;

import java.io.*;
import java.util.Scanner;

public class boj_11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        hanoi(1, 3, n);
        System.out.println((int) (Math.pow(2, n) - 1));
        System.out.println(sb.toString());
    }

    public static void hanoi(int from, int to, int n) {
        if (n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }

        hanoi(from, 6-from-to, n-1);
        sb.append(from + " " + to + "\n");
        hanoi(6-from-to, to, n-1);
    }
}
